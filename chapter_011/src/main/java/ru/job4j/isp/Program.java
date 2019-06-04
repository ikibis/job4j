package ru.job4j.isp;

public class Program {
    private final Storage storage = new Storage();

    public void addTask(String name, String parentTaskNumber) {
        storage.addItem(name, parentTaskNumber);
    }

    public void showTasks() {
        storage.showItems();
    }
}