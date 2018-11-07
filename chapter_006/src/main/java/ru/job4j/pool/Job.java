package ru.job4j.pool;

public class Job implements Runnable {
    int number;

    public Job() {
        this.number++;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.number);
    }
}

