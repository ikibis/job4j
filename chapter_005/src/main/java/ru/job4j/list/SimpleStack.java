package ru.job4j.list;

public class SimpleStack<E> extends DynamicLinkedList<E> {

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(E date) {
        super.addFirst(date);
    }
    /**
     * Метод возвращает и удаляет последний элемент.
     */
    public E poll() {
        return super.removeFirst();
    }
}







