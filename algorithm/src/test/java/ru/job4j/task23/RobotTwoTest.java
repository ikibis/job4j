package ru.job4j.task23;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotTwoTest {

    int[][] board;

    @Before
    public void prepare() {
        board = new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
    }

    @Test
    public void whenXIs2AndYIs1() {
        int result = new RobotTwo().optimalWay(board, 0, 0, 1, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenXIs2AndYIs0() {
        int result = new RobotTwo().optimalWay(board, 0, 0, 2, 0);
        assertThat(result, is(4));
    }
}
