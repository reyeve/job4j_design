package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String[] temp = args[i].split("=", 2);
            values.put(temp[0].substring(1), temp[1]);
        }
    }

    private static boolean checker(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            if (argument.charAt(1) == '=') {
                throw new IllegalArgumentException(String.
                        format("Error: This argument '%s' does not contain a key", argument));
            }
            if (!argument.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", argument));
            }
            if (argument.charAt(0) != '-') {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", argument));
            }
            String[] temp = argument.split("=");
            if (temp.length < 2) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", argument));
            }
        }
        return true;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        if (checker(args)) {
            names.parse(args);
        }
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}