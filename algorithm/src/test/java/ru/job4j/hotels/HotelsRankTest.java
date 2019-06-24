package ru.job4j.hotels;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HotelsRankTest {
    @Test
    public void getRatingOne() {
        int[] rating = new int[]{99, 2, 100, 50, 1};
        int[] result = new HotelsRank().setStars(5, rating);
        System.out.println(Arrays.toString(result));
        int[] expected = new int[]{4, 2, 5, 3, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void getRatingTwo() {
        int[] rating = new int[]{100, 90, 10, 20, 50, 60, 40, 30, 80, 70};
        int[] result = new HotelsRank().setStars(10, rating);
        System.out.println(Arrays.toString(result));
        int[] expected = new int[]{5, 5, 1, 1, 3, 3, 2, 2, 4, 4};
        assertThat(result, is(expected));
    }
}
