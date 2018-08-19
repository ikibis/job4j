package ru.job4j.array;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Arrays;

public class ArrayCopy {
    /**
     * Метод должен два отсортированных массива.
     * @param array1 входной массив.
     * @param array2 входной массив.
     * @return – результат - отсортированный массив.
     */
    public int[] consolidation(final int[] array1, final int[] array2) {
        int newLength = array1.length + array2.length;
        int count = 0;
        int [] outputArray = new int[newLength];
        for (int i = 0; ; i++) {
            if (array1[i] == array2[i]) {
                outputArray[count++] = array1[i];
                outputArray[count++] = array2[i];
            }
            if (array1[i] < array2[i]) {
                outputArray[count++] = array1[i];
                outputArray[count++] = array2[i];
            }
            if (array1[i] > array2[i]) {
                outputArray[count++] = array2[i];
                outputArray[count++] = array1[i];
            }
            if (count == newLength) {
                break;
            }
        }
        return outputArray;
    }
}
