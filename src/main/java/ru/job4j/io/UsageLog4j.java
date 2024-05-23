package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("Char={}, int={}, byte={}, short={}, long{}, double={}, float={}, bool={}", 'h', 5, 1, 8, 100L, 3.14D, 555.00F, true);
    }

}