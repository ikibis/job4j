package ru.job4j.array;

        import org.junit.Test;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class ArrayCopyTest {
    @Test
    public void whenConsolidationWithoutDuplicate() {
        ArrayCopy arrc = new ArrayCopy();
        int[] source1 = {1, 3, 5, 7, 9};
        int[] source2 = {2, 4, 6, 8, 10};
        int[] result = arrc.join(source1, source2);
        int[] correctly = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(correctly));
    }
    @Test
    public void whenConsolidationWithDuplicate() {
        ArrayCopy arrc = new ArrayCopy();
        int[] source1 = {1, 1, 5, 7, 9};
        int[] source2 = {1, 2, 2, 8, 9};
        int[] result = arrc.join(source1, source2);
        int[] correctly = {1, 1, 1, 2, 2, 5, 7, 8, 9, 9};
        assertThat(result, is(correctly));
    }
    @Test
    public void whenConsolidationWithDuplicate1() {
        ArrayCopy arrc = new ArrayCopy();
        int[] source1 = {1, 1, 5, 7, 9};
        int[] source2 = {1, 2, 2};
        int[] result = arrc.join(source1, source2);
        int[] correctly = {1, 1, 1, 2, 2, 5, 7, 9};
        assertThat(result, is(correctly));
    }
}