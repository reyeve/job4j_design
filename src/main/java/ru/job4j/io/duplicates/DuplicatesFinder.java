package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder extends SimpleFileVisitor<Path> {
    private List<FileProperty> list = new ArrayList<>();
    private Map<Path, FileProperty> map = new HashMap<>();

    public List<Path> getFiles() {
        List<Path> outList = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            if (list.indexOf(list.get(i)) == list.lastIndexOf(list.get(i))) {
                list.remove(list.get(i));
                i--;
            }
            i++;
        }
        for (Map.Entry<Path, FileProperty> entry : map.entrySet()) {
                Path path = entry.getKey();
                FileProperty fileP = entry.getValue();
                if (list.contains(fileP)) {
                    outList.add(path);
                }

            }

        return outList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        list.add(fileProperty);
        map.put(file, fileProperty);
        return FileVisitResult.CONTINUE;
    }
}
