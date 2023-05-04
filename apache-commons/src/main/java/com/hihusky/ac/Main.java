package com.hihusky.ac;

import org.apache.commons.lang3.tuple.Pair;

public class Main {
    public static void main(String[] args) {
        Pair<String, String> pair = Pair.of("name", "Ming");
        System.out.println(pair.getLeft() + ": " + pair.getRight());
    }
}
