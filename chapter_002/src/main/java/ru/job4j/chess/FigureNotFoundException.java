package ru.job4j.chess;


/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis */

/**
 * Класс, для нового исключения.
 */
public class FigureNotFoundException extends IllegalStateException  {
    /**
     * Метод сообщение при выбрасывании исключения.
     * @param msg сообщение.
     */
    public FigureNotFoundException(final String msg) {
        super(msg);
    }
}