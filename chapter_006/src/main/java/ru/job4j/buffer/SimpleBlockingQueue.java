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

    public synchronized void offer(T value) {
        this.queue.offer(value);
    }
    public synchronized int size() {
        return this.queue.size();
    }
    public synchronized T poll() {
        return this.queue.poll();
    }
    public synchronized T peek() {
        return this.queue.peek();
    }
}
