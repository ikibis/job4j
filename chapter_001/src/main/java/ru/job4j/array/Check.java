package ru.job4j.array;
/**
* @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
* @version $Id$
 * @since 0.1
*/
public class Check {
    /**
      * Метод должен проверить, что все элементы в массиве true или false.
      * @param  data входной массив.
      * @return – результат - результат проверки true или false.
      */
    public boolean mono(final boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0] != data[i]) {
                    result = false;
                    break;
            }
        }
        return result;
    }
}
