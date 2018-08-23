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
     * @param a входной массив.
     * @param b входной массив.
     * @return – результат - отсортированный массив.
     */
    public int[] join(int[] a,  int[] b) {
        int i = a.length - 1;
        int j = b.length - 1;
        int k = a.length + b.length;
        int[] out = new int[k];
        while (k > 0) {
            out[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        }
        return out;
    }
}

