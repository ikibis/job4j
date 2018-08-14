package ru.job4j.max;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Выводит максимальное из двух чисел.
     * @ int first, int second сравниваемые числа.
     * @return Результат-максимальное число.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second ;
    }
}