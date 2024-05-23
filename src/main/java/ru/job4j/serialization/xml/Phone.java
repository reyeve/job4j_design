package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class Phone {

    @XmlAttribute
    private String model;
    @XmlAttribute
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
