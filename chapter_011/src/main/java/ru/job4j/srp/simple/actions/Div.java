package ru.job4j.srp.simple.actions;

import java.util.List;

public class Div implements Action {
    @Override
    public double compute(List<Double> list) {
        return list.get(0) / list.get(1);
    }
}
