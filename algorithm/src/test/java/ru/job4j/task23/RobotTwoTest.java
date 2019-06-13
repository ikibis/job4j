package ru.job4j.task23;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.task22.Robot;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotTwoTest {

    int[][] board;

    @Before
    public void prepare() {
        board = new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
    }

    @Test
    public void whenA() {
        int result = new RobotTwo().optimalWay(board, 0, 0, 2, 0);
        assertThat(result, is(5));
    }
}
