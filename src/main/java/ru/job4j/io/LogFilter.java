package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            List<String> out = new ArrayList<>();
            List<String> temp = input.lines().toList();
            String[] str = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                str[i] = temp.get(i);
            }
            for (int i = 0; i < str.length; i++) {
                String[] temp2;
                temp2 = str[i].split(" ");
                if (temp2[temp2.length - 2].equals("404")) {
                    out.add(str[i]);
                }
            }
            return out;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(out)))) {
            data.forEach(output::println);
            }  catch (IOException e) {
            e.printStackTrace();
        }
        }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}