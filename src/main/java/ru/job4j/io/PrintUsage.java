package ru.job4j.io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"))) {
            stream.println("Из PrintStream в FileOutputStream");
            stream.write("Новая строка".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
