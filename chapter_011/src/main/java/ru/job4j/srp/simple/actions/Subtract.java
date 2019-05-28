package ru.job4j.srp.simple.actions;

public class Subtract implements Action {
    @Override
    public double compute(double first, double second) {
        return first - second;
    }
}
