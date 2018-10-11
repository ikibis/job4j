package ru.job4j.list;

public class SimpleStack<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.prev = this.last;
        this.last = newLink;
        this.size++;
    }
    /**
     * Метод удаляет и возвращает элемент из конца списка.
     */
    public E poll() {
        final Node<E> l = last;
        E element = l.date;
        Node<E> prev = l.prev;
        l.date = null;
        l.prev = null;
        last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }
        size--;
        return element;
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
}

