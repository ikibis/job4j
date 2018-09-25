package ru.job4j.function;

import java.util.function.*;
import java.util.*;

public class FunctionRealisation {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> out = new ArrayList<>();
        for (double index = start; index <= end; index++) {
            out.add(func.apply(index));
        }
        return out;
    }
}