package ru.job4j.array;
/**
* @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
* @version $Id$
* @since 0.1
*/
public class MatrixCheck {
/**
* Метод должен проверить, что все элементы по диагоналям равны true или false.
* @param  data входной массив.
* @return результат - результат проверки.
*/
	public boolean mono(final boolean[][] data) {
        	boolean result = true;
        	for (int i = 0; i < data.length; i++) {
            		if (data[0][0] != data[i][i]) {
                		result = false;
                		break;
            		}
            		if (data[0][data.length - 1] != data[i][data.length - i - 1]) {
                		result = false;
                		break;
            		}
        	}
        	return result;
	}
}
