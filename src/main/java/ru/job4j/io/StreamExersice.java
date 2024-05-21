package ru.job4j.io;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamExersice {

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> out = iteratorToStream(it).flatMap(s -> iteratorToStream(s)).toList();
        return out;
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED),
                false);
    }
}
