package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionRealisationTest {
    @Test
    public void whenLinear() {
        FunctionRealisation calc = new FunctionRealisation();
        List<Double> result = calc.diapason(
                0, 2,
                (index) -> {
                    return 7 * index;
                }
        );
        List<Double> expect = new ArrayList<>();
        expect.add(0.0);
        expect.add(7.0);
        expect.add(14.0);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSquare() {
        FunctionRealisation calc = new FunctionRealisation();
        List<Double> result = calc.diapason(
                0, 2,
                (index) -> {
                    return Math.pow(index, 2);
                }
        );
        List<Double> expect = new ArrayList<>();
        expect.add(0.0);
        expect.add(1.0);
        expect.add(4.0);
        assertThat(result, is(expect));
    }

    @Test
    public void whenLn() {
        FunctionRealisation calc = new FunctionRealisation();
        List<Double> result = calc.diapason(
                0, 2,
                (index) -> {
                    return Math.exp(index);
                }
        );
        List<Double> expect = new ArrayList<>();
        expect.add(1.0);
        expect.add(2.718281828459045);
        expect.add(7.38905609893065);
        assertThat(result, is(expect));
    }
}