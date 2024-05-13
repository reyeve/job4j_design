package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
        PrintWriter output = new PrintWriter(new BufferedWriter((new FileWriter(target))))) {
            List<String> list = input.lines().filter(s -> !s.isEmpty())
                    .toList();
            boolean scanner = false;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                boolean errorString = s.contains("400") || s.contains("500");
                boolean lastString = i == list.size() - 1;
                if (errorString && !scanner) {
                    String str = s.split(" ")[1] + ";";
                    output.write(str);
                    scanner = true;
                } else if ((scanner) && (!errorString || lastString)) {
                    String str1 = s.split(" ")[1] + ";";
                    output.write(str1 + ((lastString) ? "" : System.lineSeparator()));
                    scanner = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
        analysis.unavailable("data/server2.log", "data/target2.csv");
    }
}