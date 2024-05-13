package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IllegalArgumentException {
        try (BufferedReader input = new BufferedReader(new FileReader(this.path))) {
            input.lines()
                    .filter(s -> {
                        String[] a = s.split(" ");
                        String el = a[0];
                        return !el.equals("#") && !el.isEmpty();
                    })
                    .map(s -> {
                        if (!s.contains("=")) {
                            throw new IllegalArgumentException();
                        }
                        String[] temp = s.split("=", 2);
                        values.put(temp[0], temp[1]);
                    return null;
                    }).collect(Collectors.toList());
//            for (int i = 0; i < out1.size(); i++) {
//                System.out.println(out1.get(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
        System.out.println("-----------------");
        Config config = new Config("data/app.properties");
        config.load();
        System.out.println(config.values.entrySet());
        System.out.println(config.value("huy"));
    }

}