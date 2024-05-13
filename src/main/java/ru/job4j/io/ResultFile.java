package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/tablicaUmnojeniya.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    Integer n = i * j;
                    Integer j1 = j;
                    Integer i1 = i;
                    String out = i1.toString() + " "  + "*" + " " + j1.toString() + " " + "=" + " " + n.toString();
                    output.write(out.getBytes());
                    output.write(System.lineSeparator().getBytes());
                }
                output.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}