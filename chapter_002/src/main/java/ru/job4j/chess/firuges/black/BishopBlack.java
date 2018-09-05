package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Ilya Kibis
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest)  {
        if (!isDiagonal(source, dest)) {
            System.out.println("Нельзя так ходить!!!");
        }
        Cell[] steps = new Cell[]{dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int delta = 1;
        for (int i = 1; i < 8; i++) {
            if (
                    ((dest.x == (source.x + delta * i)) && (dest.y == (source.y + delta * i)))
                            || ((dest.x == (source.x + delta * i)) && (dest.y == (source.y - delta * i)))
                            || ((dest.x == (source.x - delta * i)) && (dest.y == (source.y - delta * i)))
                            || ((dest.x == (source.x - delta * i)) && (dest.y == (source.y + delta * i)))
                ) {
                    result = true;
            }
        }
        return result;
    }
}