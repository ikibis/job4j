package ru.job4j.task21;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScriptLoaderTest {

    Map<Integer, List<Integer>> map;

    @Before
    public void prepare() {
        map = new HashMap<>();
        map.put(1, List.of(2, 3));
        map.put(2, List.of(4));
        map.put(3, List.of(4, 5));
        map.put(4, List.of());
        map.put(5, List.of());
    }

    @Test
    public void whenA() {
        List result = new ScriptLoader().load(map, 1);
        System.out.println(result);
        assertThat(result, is(List.of(4, 2, 4, 5, 3, 1)));
    }
}
