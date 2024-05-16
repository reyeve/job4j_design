package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DuplicatesOut {
    public static void main(String[] args) throws IOException {
        DuplicatesFinder outF = new DuplicatesFinder();
        Path path = Paths.get("C:\\projects\\job4j_design\\data");
        Files.walkFileTree(path, outF);
        List<Path> list = outF.getFiles();
        Set<Path> names = getUniqueNames(list);
        for (Path name : names) {
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                Path file = list.get(i);
                if (file.getFileName().equals(name)) {
                    if (flag) {
                        System.out.println(name + " - " + file.toFile().length() + " byte");
                        flag = false;
                    }
                    System.out.println(file);
                }
            }
        }
    }

    public static Set<Path> getUniqueNames(List<Path> list) {
        Set<Path> set = new HashSet<>();
        for (Path p : list) {
            set.add(p.getFileName());
        }
        return set;
    }
}
