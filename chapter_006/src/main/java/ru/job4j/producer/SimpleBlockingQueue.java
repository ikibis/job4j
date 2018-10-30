package ru.job4j.producer;

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

    public void offer(T value) {
        this.queue.offer(value);
    }
    public int size() {
        return this.queue.size();
    }
    public T poll() {
        return this.queue.poll();
    }
}
