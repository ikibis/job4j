package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {

        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
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
            public boolean hasNext() throws ConcurrentModificationException {
                checkModCount();
                return iteratorIndex < size;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
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
