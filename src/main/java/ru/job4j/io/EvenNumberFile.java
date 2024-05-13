package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            for (String str : numbers) {
                int n = Integer.parseInt(str.trim());
                if (n % 2 == 0) {
                    System.out.println(n + " является четным числом.");
                } else {
                    System.out.println(n + " является не четным числом.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
