package ru.job4j.buffer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    SimpleBlockingQueue<Integer> queue;

    private class Producer extends Thread {
        private SimpleBlockingQueue<Integer> queue;

        private Producer(final SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                queue.offer(i);
            }
        }
    }

    private class Consumer extends Thread {
        private SimpleBlockingQueue<Integer> queue;

        private Consumer(final SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                queue.poll();
            }
        }
    }

    @Before
    public void beforeTest() {
        queue = new SimpleBlockingQueue<>();
    }

    Thread producer = new Producer(queue);
    Thread consumer = new Consumer(queue);

    @Test
    public void when2Threads() throws InterruptedException {
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        //assertThat(queue.size(), is(0));
    }
}
