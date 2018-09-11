package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            tasks.add(task);
            System.out.println("First " + this.tasks.getFirst().getPriority() + " " + task.getPriority());
        } else {
            if (this.tasks.getFirst().getPriority() < task.getPriority()) {
                System.out.println(this.tasks.getFirst().getPriority() + " " + task.getPriority());
                this.tasks.addLast(task);
            } else {
                this.tasks.addFirst(task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}