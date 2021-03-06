package ru.job4j.loop;
 import org.junit.Test;
 import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 public class PaintTest {
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst,
            is(
                    new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                            .add("   ^   ")
                            .add("  ^^^  ")
                            .add(" ^^^^^ ")
                            .add("^^^^^^^")
                            .toString()
            )
        );
    }
} 