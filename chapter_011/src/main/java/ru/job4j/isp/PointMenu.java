package ru.job4j.isp;

public class PointMenu {
    private int number;
    private String description;
    private String action;

    public PointMenu(int number, String description, String action) {
        this.number = number;
        this.description = description;
        this.action = action;
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

}
