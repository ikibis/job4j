package ru.job4j.switcher;

public class Switcher {
    private String text;

    public Switcher(String text) {
        this.text = text;
    }

    public void setText(int number) {
        this.text = this.text + number;
    }

    public String getText() {
        return this.text;
    }
}
