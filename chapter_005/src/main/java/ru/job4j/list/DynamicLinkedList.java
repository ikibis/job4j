package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
public class DynamicLinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void addFirst(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
        throw new NoSuchElementException();
        }
        final E element = f.date;
        final Node<E> next = f.next;
        f.date = null;
        f.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> prev;
        Node(E date) {
            this.date = date;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int iteratorIndex = 0;
            private int modCountCopy = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return iteratorIndex < size;
            }

            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(iteratorIndex++);
            }

            private void checkModCount() throws ConcurrentModificationException {
                if (modCountCopy != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
