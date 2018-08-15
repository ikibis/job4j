package ru.job4j.array;
/**
* @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
* @version $Id$
 * @since 0.1
*/
public class Check {
    public boolean mono(final boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            boolean arrayElement = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (arrayElement != data[j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
