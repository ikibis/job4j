package ru.job4j.list;

public class SimpleStack<E> {
    public DynamicLinkedList<E> stack;

    public SimpleStack() {
        this.stack = new DynamicLinkedList<>();
    }

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(E date) {
        stack.addFirst(date);
    }

    /**
     * Метод возвращает и удаляет последний элемент.
     */
    public E poll() {
        return stack.removeFirst();
    }

    public int getSize() {
        return stack.getSize();
    }
}







