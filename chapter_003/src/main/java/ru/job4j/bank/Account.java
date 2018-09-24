package ru.job4j.bank;

public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double newValue) {
        this.value = newValue;
    }

    public String getReqs() {
        return this.requisites;
    }
}








