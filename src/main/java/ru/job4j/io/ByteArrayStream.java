package ru.job4j.io;

import java.io.ByteArrayInputStream;

public class ByteArrayStream {

    public static void main(String[] args) {
        byte[] bytes = new byte[] {'J', 'a', 'v', 'a'};
        String str = "123456789";
        byte[] bytes2 = str.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        ByteArrayInputStream stream2 = new ByteArrayInputStream(bytes2, 4, 8);
        int data;
        int data2;
        while ((data = stream.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();
        while ((data2 = stream2.read()) != -1) {
            System.out.print((char) data2);
        }
    }

}