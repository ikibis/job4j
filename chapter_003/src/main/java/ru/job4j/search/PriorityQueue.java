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
        if (this.tasks.size() < task.getPriority()) {
            for(int i = this.tasks.size(); i < task.getPriority(); i++) {
                this.tasks.add(i, null);
            }
        }
        System.out.println(this.tasks.size());
        this.tasks.set(task.getPriority() - 1, task);
    }

    public Task take() {
        while(this.tasks.getFirst() == null) {
            this.tasks.poll();
        }
        return this.tasks.poll();
    }
}