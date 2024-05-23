package ru.job4j.serialization.json;

public class Phone {
    private String model;
    private int year;

    public Phone() { }

    public Phone(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Модель телефона: "  + this.model + ".  Год выпуска: " + this.year + ".";
    }
}
