package ru.job4j.switcher;

import java.util.concurrent.Semaphore;

public class Switcher extends Thread {
    Message message;
    Thread threadOne;
    Thread threadTwo;
    Semaphore semaphore;
    public int messageFinal = 10;

    public Switcher(final Message message) {
        this.message = message;
        semaphore = new Semaphore(1);
        threadOne = new ThreadOne(semaphore, message);
        threadTwo = new ThreadTwo(semaphore, message);
    }

    public void switchNow() {
        try {
            if (threadTwo.getState() == State.RUNNABLE) {
                threadTwo.wait();
                threadOne.notify();
            }
            if (threadOne.getState() == State.RUNNABLE) {
                threadOne.wait();
                if (threadTwo.getState() == State.NEW) {
                    threadTwo.start();
                }
                if (threadTwo.getState() == State.WAITING) {
                    threadTwo.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {
        threadOne.start();
        while (!Thread.currentThread().isInterrupted()) {
            if (message.getSize() == messageFinal) {
                messageFinal += 10;
                System.out.println(message.getSize());
                threadOne.interrupt();
                this.switchNow();
            }
            semaphore.release();
        }
    }
}