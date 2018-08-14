package ru.job4j.condition;
/**
 * @author Ilya Kibis (mailto:i.kibis@gmail.com)
 * @version $Id$
 * @since 10.08.2018
 */
import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void manWeight() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.4, 0.1));
    }
}