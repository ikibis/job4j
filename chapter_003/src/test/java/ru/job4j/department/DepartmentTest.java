package ru.job4j.department;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentTest {

    @Test
    public void whenSort() {
        List<String> result = new LinkedList<>();
        result.add("K1\\SK1");
        result.add("K1\\SK2");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K2");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        result = new DepartmentSort().generating(result);

        List<String> expect = new LinkedList<>();
        expect.add("K1");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK2");
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K2\\SK1\\SSK2");

        assertThat(result, is(expect));
    }

    @Test
    public void whenReverse() {
        List<String> result = new LinkedList<>();
        result.add("K1\\SK1");
        result.add("K1\\SK2");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K2");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");
        result = new DepartmentSort().reverse(result);

        List<String> expect = new LinkedList<>();

        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK2");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K1");
        expect.add("K1\\SK2");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK1\\SSK1");

        assertThat(result, is(expect));
    }
}



