package ru.job4j.array;
 /**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    public int[] turn(final int[] array) {
            for (int i = 0; i < (array.length / 2); i++) {
                int toReverse = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = toReverse;
            }
        return array;
    }
}
