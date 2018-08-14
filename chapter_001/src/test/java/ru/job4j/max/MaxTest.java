package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest{
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 1);
        assertThat(result, is(3));
    }
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenSecondLessFirstLessThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 1, 5);
        assertThat(result, is(5));
    }
}