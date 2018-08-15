package ru.job4j.array;
/**
* @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
* @version $Id$
* @since 0.1
*/
public class BubbleSort {
    /**
     * Пузырьковая сортировка массива.
     * @param  array входной массив.
     * @return Результат - вывод массива.
     */
    public int[] sort(final int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
