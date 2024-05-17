package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(args[0]);
        if (validation(args)) {
            search(start, path -> path.toFile().getName().endsWith(".txt")).forEach(System.out::println);
        }

    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static boolean validation(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Неверное количество аргументов!");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if ((args[1].charAt(0) != '.') && (args[1].length() > 1)) {
            throw  new IllegalArgumentException("Неверный второй аргумент!");
        }
        return true;
    }
}