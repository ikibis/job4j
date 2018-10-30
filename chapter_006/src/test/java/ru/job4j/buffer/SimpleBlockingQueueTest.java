package ru.job4j.buffer;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    SimpleBlockingQueue queue;

    private class Producer extends Thread {
        private SimpleBlockingQueue queue;
        final Random random = new Random();

        private Producer(final SimpleBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 5; i++) {
                if (this.queue.size() < 5) {
                    queue.offer(random.nextInt());
                } else {
                    try {
                        notifyAll();
                        currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class Consumer<T> extends Thread {
        private SimpleBlockingQueue queue;

        private Consumer(final SimpleBlockingQueue queue) {
            this.queue = queue;
        }

        private synchronized T output() {
            return (T) queue.poll();
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 5; i++) {
                if (this.queue.size() > 0) {
                    this.output();
                } else {
                    try {
                        notifyAll();
                        currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Before
    public void beforeTest() {
        queue = new SimpleBlockingQueue<Integer>();
    }

    @Test
    public void when2Threads() throws InterruptedException {
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(queue.size(), is(0));
    }
}
