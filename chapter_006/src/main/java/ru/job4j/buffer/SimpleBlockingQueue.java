package ru.job4j.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private static final Logger LOGGER = Logger.getLogger(SimpleBlockingQueue.class);
    @GuardedBy("this")
    private final Queue<T> queue;

    public SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void offer(T value) throws InterruptedException {
            while (queue.size() > 5) {
                wait();
            }
        LOGGER.info("Это информационное сообщение!" + "offer " + value);
            queue.offer(value);
            notify();
        }

    public int size() {
        return this.queue.size();
    }
    public synchronized T poll() throws InterruptedException {
            while (queue.isEmpty()) {
                wait();
            }
            T result = this.queue.poll();
        LOGGER.info("Это информационное сообщение!" + "poll " + result);
            notify();
            return result;

    }
}
