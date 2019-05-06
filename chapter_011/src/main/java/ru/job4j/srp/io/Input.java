package ru.job4j.srp.io;

public class Input {
    String input;
    String context;

    public Input(String input, String context) {
        this.input = input;
        this.context = context;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
