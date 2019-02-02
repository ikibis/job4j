package ru.job4j.parser;

import java.util.Stack;

public class Storage {
    private Stack<Vacancy> storage;

    public Storage() {
        this.storage = new Stack<>();
    }

    public void add(Vacancy vacancy) {
        this.storage.add(vacancy);
    }

    public Vacancy poll() {
        return this.storage.pop();
    }

    public boolean empty() {
        return this.storage.empty();
    }
}
