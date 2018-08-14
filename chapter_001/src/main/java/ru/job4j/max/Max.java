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
        /**
     * Выводит максимальное из трех чисел.
     * @ int first, int second , int third сравниваемые числа.
     * @return Результат-максимальное число.
     */
    public int max(int first, int second , int third) {
        return this.max(
                this.max(first, second), third
        );
    }
}