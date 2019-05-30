package ru.job4j.ocp.engineer.actions;

import ru.job4j.srp.simple.actions.Action;

import java.util.List;

public class Ctg implements Action {
    @Override
    public double compute(List<Double> list) {
        return 1 / Math.tan(list.get(0));
    }
}