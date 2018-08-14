package ru.job4j.loop;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Подсчет суммы чётных чисел в диапазоне.
     * @ int start, int finish границы диапазона.
     * @return Результат-сумма чисел.
     */
    public int sumEven(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}