package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JavaJsonUsage {
    public static void main(String[] args) {
        JSONObject jsonPhone = new JSONObject("{\"model\": \"Iphone\"," + "\"year\":2002}");
        List<String> list = new ArrayList<>();
        list.add("VAL");
        list.add("LOL");
        JSONArray jsonGames = new JSONArray(list);
        String[] games = {"VAL", "lol"};
        final Sofia sofia = new Sofia(21, true, "люблю тебя", new Phone("Iphone", 2024), games);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", sofia.getAge());
        jsonObject.put("goodMood", sofia.isGoodMood());
        jsonObject.put("codeWord", sofia.getCodeWord());
        jsonObject.put("phone", jsonPhone);
        jsonObject.put("games", jsonGames);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(sofia).toString());
    }
}
