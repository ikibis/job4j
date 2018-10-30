package ru.job4j.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue;

    public SimpleBlockingQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (!queue.isEmpty()) {
            wait();
        }
        this.queue.offer(value);
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
        notify();
        return result;
    }
}
