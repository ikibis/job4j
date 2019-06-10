package ru.job4j.task22;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.task21.ScriptLoader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotTest {

    int[][] board;

    @Before
    public void prepare() {
        board = new int[][]{
                {1, 2, 3},
                {1, 3, 6},
                {1, 1, 5}
        };
    }

    @Test
    public void whenA() {
        int result = new Robot().optimalWay(board, 0, 0, 2, 2);
        System.out.println(board[1][2]);
        /*assertThat(result, is(List.of(4, 2, 4, 5, 3, 1)));*/
    }
}
