package ru.job4j.examples;

public class MemoryStorage implements Storage {

    @Override
    public void add(User user) {
        System.out.println("User stored to memory ");
    }
}
