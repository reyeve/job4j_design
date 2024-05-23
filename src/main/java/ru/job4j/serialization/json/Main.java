package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});
        String[] games = {"LOL", "BDB", "Valorant"};
        final Sofia sofia = new Sofia(21, true, "люблю тебя", new Phone("Iphone", 2024), games);

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
        System.out.println("-------  А теперь София!");
        System.out.println(gson.toJson(sofia));

        /* Создаём новую json-строку с модифицированными данными*/
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        /* Превращаем json-строку обратно в объект */
        final Person personMod = gson.fromJson(personJson, Person.class);
         final String sofiaJson =
                "{"
                    + "\"age\":18,"
                    + "\"goodMood\":false,"
                    + "\"codeWord\":\"и я тебя\","
                    + "\"phone\":"
                    + "{"
                    + "\"model\":\"Xmeow\","
                    + "\"year\":2002"
                    + "},"
                        + "\"games\":"
                        + "[\"CS2\", \"WOT\"]"
                    + "}";
        System.out.println(personMod);
        System.out.println("---------------");
        final Sofia sofiaXD = gson.fromJson(sofiaJson, Sofia.class);
        System.out.println(sofiaXD);
    }
}