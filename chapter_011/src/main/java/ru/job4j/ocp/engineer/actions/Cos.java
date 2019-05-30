package ru.job4j.ocp.engineer.actions;

import ru.job4j.srp.simple.actions.Action;

import java.util.List;

public class Cos implements Action {
    @Override
    public double compute(List<Double> list) {
        return Math.cos(list.get(0));
    }
}