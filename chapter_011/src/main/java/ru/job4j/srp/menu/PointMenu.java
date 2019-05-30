package ru.job4j.srp.menu;

public class PointMenu {
    private int number;
    private String description;
    private String action;
    private int numbers;

    public PointMenu(int number, String description, String action, int numbers) {
        this.number = number;
        this.description = description;
        this.action = action;
        this.numbers = numbers;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getAction() {
        return action;
    }

    public int getNumbers() {
        return numbers;
    }
}
