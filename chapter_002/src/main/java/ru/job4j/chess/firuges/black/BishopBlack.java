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
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[64];
        int deltaX = 1;
        int deltaY = 1;
        if (source.y != dest.y && source.x != dest.x) {
            for (int i = 0; i < 8; i++) {
                if (dest.x >= 0 && dest.y >= 0 && dest.x < 8 && dest.y < 8)
                    steps[index] = dest.x

        }
        return steps;
        if (source.y != dest.y + 1 && source.x != dest.x) {
            steps = new Cell[] { dest };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}



