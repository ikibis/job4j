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
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        Cell pos = testBishop.position();
        assertThat(
                pos,
                is(Cell.C1)
        );
    }
    @Test
    public void testCopy() {
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        Figure testBishop2 = testBishop.copy(Cell.G1);
        Cell pos2 = testBishop2.position();
        assertThat(
                pos2,
                is(Cell.G1)
        );
    }
    @Test
    public void whenWayTurnDiagonal() {
        BishopBlack testBishop = new BishopBlack(Cell.C1);
        Cell[] testTurn = testBishop.way(Cell.C1, Cell.G5);
        assertThat(
                testTurn.length,
                is(4)
        );
        assertThat(
                testTurn,
                is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5})
        );
    }
}

