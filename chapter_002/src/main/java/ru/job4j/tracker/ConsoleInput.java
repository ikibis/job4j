
package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis
 */
import java.util.Scanner;
import java.util.List;
/**
 * Класс, считывающий ввод пользователя.
 */
public final class ConsoleInput implements Input {
    /**
     * Создаем объект класса Scanner.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод, возвращающий ввод пользователя.
     * @param question пункт меню.
     * @return ввод пользователя.
     */
    public String ask(final String question) {
        System.out.print(question);
        return scanner.next();
    }
    /**
     * Метод, возвращающий пункт меню.
     * @param question описание пункта меню.
     * @param range количество пунктов меню.
     * @return ввод пользователя.
     */
    public int ask(final String question, final List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}

