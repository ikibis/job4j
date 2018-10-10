package ru.job4j.function;

import java.util.Arrays;

public class Stream {
    public int demo(int[] i) {
        return Arrays.stream(i).filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, Integer::sum);
    }
}
