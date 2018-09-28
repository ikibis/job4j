package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VendingTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        int[] actual = new Vending().changes(50, 32);
        int[] expected = new int[] {10, 5, 2, 1};
        assertThat(actual, is(expected));
    }
}
