package ru.job4j.pool;

import ru.job4j.buffer.SimpleBlockingQueue;

public class TasksPool extends Thread {
    private final SimpleBlockingQueue<Runnable> tasks;

    public TasksPool(SimpleBlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
        this.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                tasks.poll().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

