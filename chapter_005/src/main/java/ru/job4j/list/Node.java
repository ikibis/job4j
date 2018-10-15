package ru.job4j.list;

public class Node<E> {
    E date;
int size = 0;
    Node(E date) {
        this.date = date;
        this.size++;
    }
    Node<E> next;
}
