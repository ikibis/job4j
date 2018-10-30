package ru.job4j.buffer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    SimpleBlockingQueue<Integer> queue;
    Thread producer;
    Thread consumer;

    private class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    queue.offer(i);
                    System.out.println("offer " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    Integer poll = queue.poll();
                    System.out.println("poll " + poll);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Before
    public void beforeTest() {
        queue = new SimpleBlockingQueue<>();
        producer = new Producer();
        consumer = new Consumer();
    }

    @Test
    public void when2Threads() throws InterruptedException {
        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
        assertThat(queue.size(), is(0));
    }
}
