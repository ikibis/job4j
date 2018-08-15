package ru.job4j.array;
 /**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
     /**
      * Постороение матрицы массива, таблица умножения.
      * @param  size входной массив.
      * @return Результат - вывод массива.
      */
    public int[][] multiple(final int size) {
        int[][] table = new int[size][size];
        for (int i = size; i > 0; i--) {
            for (int j = size; j > 0; j--) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
