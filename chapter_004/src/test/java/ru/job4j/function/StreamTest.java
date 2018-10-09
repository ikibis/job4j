package ru.job4j.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamTest {
        @Test
        public void whenLinear() {
            int[] i = new int[]{1, 2, 3, 4, 5, 6};
            int result = new Stream().demo(i);
            assertThat(result, is(56));
        }
}
