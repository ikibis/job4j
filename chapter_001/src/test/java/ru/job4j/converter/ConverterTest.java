package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    @Test
    public void when3EuroToRubleThen210() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(3);
        assertThat(result, is(210));
    }
    @Test
    public void when2DollarToRubleThen120() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(2);
        assertThat(result, is(120));
    }
}