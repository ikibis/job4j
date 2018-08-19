package ru.job4j.array;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayCopy {
    /**
     * Метод должен два отсортированных массива.
     * @param array1 входной массив.
     * @param array2 входной массив.
     * @return – результат - отсортированный массив.
     */
    public int[] consolidation(final int[] array1, final int[] array2) {
        int [] outputArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++)
            outputArray[i] = array1[i];
        for (int i = 0; i < array2.length; i++)
            outputArray[i + array1.length] = array2[i];
        for (int i = outputArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (outputArray[j] > outputArray[j + 1]) {
                    int tmp = outputArray[j];
                    outputArray[j] = outputArray[j + 1];
                    outputArray[j + 1] = tmp;
                }
            }
        }
        return outputArray;
    }
}

