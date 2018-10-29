package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RepeatingElementsTest {
    RepeatingElements re;

    @Before
    public void beforeTest() {
        re = new RepeatingElements();
    }

    @Test
    public void whenFindRepeatElements() {
        Set<Character> expect = new TreeSet<>();
        expect.add('s');
        expect.add('o');
        expect.add('r');
        assertThat(re.checkRepeat("processor"), is(expect));
    }
}

