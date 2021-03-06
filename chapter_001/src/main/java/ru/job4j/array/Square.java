package ru.job4j.array;
 /**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Вывод массива.
     * @param  bound целое число.
     * @return Результат - вывод массива.
     */
    public int[] calculate(final int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < result.length; i++) {
            result[i] = ++i * i--;
        }
        return result;
    }
}
