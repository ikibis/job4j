package ru.job4j.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue;

    public SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
    }

    public void offer(T value) throws InterruptedException {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.wait();
            }
            queue.offer(value);
            queue.notify();
        }
    }
    public int size() {
        return this.queue.size();
    }
    public T poll() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            T result = this.queue.poll();
            queue.notify();
            return result;
        }
    }
}
