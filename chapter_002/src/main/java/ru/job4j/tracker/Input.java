package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis
 */
import java.util.List;
/**
 * Интерфейс, для считывания ввода пользователя.
 */
public interface Input {
    /**
     * Метод, для ввода данных пользователем.
     * @param question пункт меню.
     * @return ввод пользователя.
     */
    String ask(String question);
    /**
     * Метод, для ввода пункта меню пользователем.
     * @param question пункт меню.
     * @param range количество пунктов меню.
     * @return ввод пользователя.
     */
    int ask(String question, List<Integer> range);
}

