package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis
 */

/**
 * Класс, для нового исключения.
 */
public class MenuOutException extends RuntimeException  {
    /**
     * Метод сообщение при выбрасывании исключения.
     * @param msg сообщение.
     */
    public MenuOutException(final String msg) {
        super(msg);
    }
}

