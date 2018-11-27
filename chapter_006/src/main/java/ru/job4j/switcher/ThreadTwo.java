package ru.job4j.switcher;

import java.util.concurrent.Semaphore;

public class ThreadTwo extends Thread {
    Message message;
    Semaphore semaphore;

    public ThreadTwo(Semaphore semaphore, Message message) {
        this.semaphore = semaphore;
        this.message = message;
    }

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                semaphore.acquire();
                message.setMessage(2);
                System.out.println(message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

