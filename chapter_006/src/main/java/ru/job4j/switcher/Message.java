package ru.job4j.switcher;

import java.util.concurrent.locks.ReentrantLock;

public class Message extends ReentrantLock {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public synchronized void setMessage(int number) {
        this.text = this.text + number;
    }

    public synchronized String getMessage() {
        return this.text;
    }

    public synchronized int getSize() {
        return text.length();
    }
}

/*
1) Реализуйте объект, который хранит в себе строку или ее представление. Объекту необходимо:
- содержать метод, который принимает на вход значение типа int, конвертирует его в строковое представление
 (например, 4 -> "4"), а затем добавляет к концу строки.
- по требованию возвращать эту строку.
2) Реализуйте 2 потока, которые в цикле добавляют всегда одно и то же число (1-й поток число 1, второй поток число 2)
 в строку из пункта 1.
Работа потоков должна быть организована таким образом, чтобы числа добавлялись в строку в следующем порядке:
 сначала 10 чисел из первого потока, затем 10 чисел из второго, затем снова 10 чисел из первого и так далее.


 нет не верно. тебе надо запустить нить. между ними проверять.
 что сначала должна писать первая нить. потом она уходить на паузу и просывается вторая нить.
 */
