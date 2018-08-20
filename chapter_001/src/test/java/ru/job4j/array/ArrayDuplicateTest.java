package ru.job4j.array;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate dupl = new ArrayDuplicate();
        String[] source = {"Hello", "Peace", "Hello", "Super", "Peace"};
        String[] result = dupl.remove(source);
        String[] correctly = {"Hello", "Peace", "Super"};
        assertThat(result, is(correctly));
    }
}