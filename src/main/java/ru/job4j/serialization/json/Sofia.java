package ru.job4j.serialization.json;

import java.util.Arrays;

public class Sofia {
    private int age;
    private boolean goodMood;
    private String codeWord;

    private Phone phone;
    private String[] games;

    public Sofia() { }

    public Sofia(int age, boolean goodMood, String codeWord, Phone phone, String[] games) {
        this.age = age;
        this.goodMood = goodMood;
        this.codeWord = codeWord;
        this.games = games;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public boolean isGoodMood() {
        return goodMood;
    }

    public String getCodeWord() {
        return codeWord;
    }

    public Phone getPhone() {
        return phone;
    }

    public String[] getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Sofia{" +
                "age=" + age +
                ", goodMood=" + goodMood +
                ", codeWord='" + codeWord + '\'' +
                ", games=" + Arrays.toString(games) +
                ", phone=" + phone +
                '}';
    }

}
