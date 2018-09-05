package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kibis Ilya
 * @version $Id$
 * @since 0.1
 */
public class BishopBlackTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void testPosition() {
        BishopBlack testBishop = new BishopBlack(Cell.valueOf("C1"));
        Cell pos = testBishop.position();
        assertThat(
                pos,
                is(Cell.valueOf("C1"))
        );
    }
    @Test
    public void testCopy() {
        BishopBlack testBishop = new BishopBlack(Cell.valueOf("C1"));
        Figure testBishop2 = testBishop.copy(Cell.valueOf("G1"));
        Cell pos2 = testBishop2.position();
        assertThat(
                pos2,
                is(Cell.valueOf("G1"))
        );
    }
    @Test
    public void whenWayTurnDiagonal() {
        BishopBlack testBishop = new BishopBlack(Cell.valueOf("C1"));
        Cell[] testTurn = testBishop.way(Cell.valueOf("C1"), Cell.valueOf("G5"));
        assertThat(
                testTurn[0],
                is(Cell.valueOf("G5"))
        );
    }
    @Test
    public void whenWayTurnNotDiagonal() {
        System.setOut(new PrintStream(this.out));
        BishopBlack testBishop = new BishopBlack(Cell.valueOf("C1"));
        testBishop.way(Cell.valueOf("C1"), Cell.valueOf("G4"));
        assertThat(
                new String(this.out.toByteArray()),
                is("Нельзя так ходить!!!\r\n")
        );
        System.setOut(this.stdout);
    }
}

