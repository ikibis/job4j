package ru.job4j.search;

import java.util.ListIterator;
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
        int entrySize = this.tasks.size();
        ListIterator<Task> it = this.tasks.listIterator();
        while (it.hasNext()) {
            int priority = it.next().getPriority();
            if (task.getPriority() < priority) {
                this.tasks.add(it.previousIndex(), task);
                break;
            }
        }
        if (entrySize == this.tasks.size()) {
            this.tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}