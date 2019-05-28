package ru.job4j.srp.engineer.actions;

import ru.job4j.srp.simple.actions.Action;

public class Sin implements Action {
    @Override
    public double compute(double first, double second) {
        return Math.sin(first);
    }
}