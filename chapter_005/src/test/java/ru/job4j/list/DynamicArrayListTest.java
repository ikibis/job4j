package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayListTest {
        private DynamicArrayList<Integer> list;

        @Before
        public void beforeTest() {
            list = new DynamicArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
        }

        @Test
        public void whenAddThreeElementsThenUseGetOneResultTwo() {
            assertThat(list.get(1), is(2));
        }
}
