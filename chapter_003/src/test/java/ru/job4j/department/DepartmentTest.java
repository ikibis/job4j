package ru.job4j.department;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentTest {

    @Test
    public void whenSort() {
        List<String> result = List.of(
                "\"K1\\SK1\"",
                "\"K1\\SK2\"",
                "\"K1\\SK1\\SSK1\"",
                "\"K1\\SK1\\SSK2\"",
                "\"K2\"",
                "\"K2\\SK1\\SSK1\"",
                "\"K2\\SK1\\SSK2\""
        );
        result = new DepartmentSort().sort(result);

        List<String> expect = List.of(
                "\"K1\"",
                "\"K1\\SK1\"",
                "\"K1\\SK1\\SSK1\"",
                "\"K1\\SK1\\SSK2\"",
                "\"K1\\SK2\"",
                "\"K2\"",
                "\"K2\\SK1\"",
                "\"K2\\SK1\\SSK1\"",
                "\"K2\\SK1\\SSK2\""
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenReverse() {
        List<String> result = List.of(
                "\"K1\\SK1\"",
                "\"K1\\SK2\"",
                "\"K1\\SK1\\SSK1\"",
                "\"K1\\SK1\\SSK2\"",
                "\"K2\"",
                "\"K2\\SK1\\SSK1\"",
                "\"K2\\SK1\\SSK2\""
        );
        result = new DepartmentSort().reverse(result);

        List<String> expect = List.of(
                "\"K2\"",
                "\"K2\\SK1\"",
                "\"K2\\SK1\\SSK2\"",
                "\"K2\\SK1\\SSK1\"",
                "\"K1\"",
                "\"K1\\SK2\"",
                "\"K1\\SK1\"",
                "\"K1\\SK1\\SSK2\"",
                "\"K1\\SK1\\SSK1\""
        );
        assertThat(result, is(expect));
    }
}



