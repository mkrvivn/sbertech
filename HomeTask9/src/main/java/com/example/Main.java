package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("s");
        l.add("z");
        var m = Stream.of(l)
                .filter((letter) -> letter.compareTo("k") > 0)
                .transform((letter) -> letter + letter)
                .toMap(String::valueOf, (letter) -> letter);
    }
}
