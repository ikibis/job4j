package ru.job4j.srp;

import ru.job4j.srp.engineer.EngineerCalculator;
import ru.job4j.srp.simple.Calculator;

public class Application {
    public static void main(String[] args) {
        new EngineerCalculator().run();
    }
}