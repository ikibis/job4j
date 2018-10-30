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

    public synchronized void offer(T value){
        while (queue.size() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.offer(value);
        System.out.println("+ " + value);
        notify();
    }

    public synchronized T poll(){
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T result = this.queue.poll();
        notify();
        System.out.println("- " + result);
        return result;
    }
}
