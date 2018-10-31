package ru.job4j.buffer;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.currentThread;

public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        AtomicBoolean flag = new AtomicBoolean(true);
        final Thread consumer = new Thread(
                () -> {
                    while (flag.get()) {
                        try {
                            System.out.println(queue.poll());
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (!flag.get()) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        try {
                            queue.offer(index);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag.set(false);
                }
        ).start();
    }
}