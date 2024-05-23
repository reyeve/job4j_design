package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "sofia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sofia {

    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean goodMood;
    @XmlAttribute
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
