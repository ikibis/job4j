package ru.job4j.array;
/**
* @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
* @version $Id$
* @since 0.1
*/
import java.util.Arrays;

public class ArrayDuplicate {
    /**
      * Метод должен убрать все дубликаты строк из массивe.
      * @param  array входной массив.
      * @return – результат - массив без дубликатов.
      */
    public String[] remove(final String[] array) {
        int newLength = array.length;
        for (int i = 0; i < newLength; i++) {
            for (int j = i + 1; j < newLength; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[newLength - 1];
                    newLength--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, newLength);
    }
}
