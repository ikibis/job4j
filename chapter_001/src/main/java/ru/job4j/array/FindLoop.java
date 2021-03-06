package ru.job4j.array;
 /**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    public int indexOf(final int[] data, final int el) {
        int result = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}
