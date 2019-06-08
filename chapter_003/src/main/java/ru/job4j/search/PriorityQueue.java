package ru.job4j.search;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        var entrySize = this.tasks.size();

        var index = tasks.stream().filter(
                tasks -> tasks.getPriority() < task.getPriority()
        ).collect(Collectors.toList()).size();
        this.tasks.add(index, task);

        if (entrySize == this.tasks.size()) {
            this.tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}