package ru.job4j.srp.actions;

public class Add implements Action {
    @Override
    public double compute(double first, double second) {
        return first + second;
    }
}
