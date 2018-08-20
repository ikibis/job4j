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
        int [] outputArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++)
            outputArray[i] = array1[i];
        for (int i = 0; i < array2.length; i++)
            outputArray[i + array1.length] = array2[i];
        Arrays.sort(outputArray);
        return outputArray;
    }
}

