package ru.job4j.list;

public class SimpleQueue<E> {
    public SimpleStack<E> queue;
    private SimpleStack<E> queueCopy = new SimpleStack<>();
    public SimpleQueue() {
        this.queue = new SimpleStack<>();
    }

    public void push(E date) {
        queue.push(date);
    }

    public E poll() {
        E result = null;
        int size = queue.getSize();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                result = queue.poll();
                break;
            }
            queueCopy.push(queue.poll());
        }
        for (int i = 0; i < size - 1; i++) {
            queue.push(queueCopy.poll());
        }
        return result;
    }
}
