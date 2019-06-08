package ru.job4j.matrix;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    Integer[][] matrix;
    List<Integer> list;

    @Before
    public void prepare() {
        matrix = new Integer[3][3];
        list = new ArrayList<>();
    }

    @Test
    public void whenMatrixToList() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j;
                list.add(j);
            }
        }
        List<Integer> result = new Matrix().matrixToList(matrix);
        assertThat(result, is(list));
    }
}
