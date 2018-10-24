package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CompareStringsTest {
    CompareStrings comp;

    @Before
    public void beforeTest() {
        comp = new CompareStrings();
    }
    @Test
    public void whenCharQuantityEquals() {
        assertThat(comp.compare1("mama", "mmaa"), is(true));
        assertThat(comp.compare2("mama", "mmaa"), is(true));
    }
    @Test
    public void whenCharQuantityNotEquals() {
        assertThat(comp.compare1("mama", "mmma"), is(false));
        assertThat(comp.compare2("mama", "mmma"), is(false));
    }
}
