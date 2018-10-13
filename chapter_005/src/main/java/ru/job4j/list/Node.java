package ru.job4j.list;

public class Node<E> {
    E date;

    Node(E date) {
        this.date = date;
    }

    E value;
    Node<E> next;
}
