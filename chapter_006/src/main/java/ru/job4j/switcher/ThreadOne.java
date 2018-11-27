package ru.job4j.switcher;

import java.util.concurrent.Semaphore;

public class ThreadOne extends Thread {
    Message message;
    Semaphore semaphore;

    public ThreadOne(Semaphore semaphore, Message message) {
        this.semaphore = semaphore;
        this.message = message;
    }

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                semaphore.acquire();
                message.setMessage(1);
                System.out.println("ThreadOne " + message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
