package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> phrases = readPhrases();
        saveLog(phrases);
    }

    private List<String> readPhrases() { // допилить рандомное чтение ответа из файла
        Scanner in = new Scanner(System.in);
        List<String> out = new ArrayList<>();
        String str = in.nextLine();
        boolean answering = true;
        while (!str.equals(OUT)) {
            out.add(str);
            if (str.equals(STOP)) {
                answering = false;
            }
            if (str.equals(CONTINUE)) {
                answering = true;
            }
            if (answering) {
                int j = (int) (Math.random() * getAnswers().size());
                String answer = getAnswers().get(j);
                System.out.println(answer);
                out.add(answer);
            }
            str = in.nextLine();

        }
        return out;
    }

    private List<String> getAnswers() {
        List<String> list = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(this.botAnswers))) {
            list = input.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.path, true)))) {
            log.forEach(s -> writer.println(s));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chatLog.txt", "C:\\projects\\job4j_design\\data\\bot_Answers.txt");
        consoleChat.run();
    }
}