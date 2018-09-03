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
        Cell[] steps = new Cell[0];
        if (!isDiagonal(source, dest)) {
            System.out.println("Нельзя так ходить!!!");
        }
        steps = new Cell[]{dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = 1;
        int deltaY = 1;
        int i = 1;
        while((source.x + deltaX * i < 8) && (source.y + deltaY * i < 8)) {
            if (dest.x == (source.x + deltaX * i) && dest.y == (source.y + deltaY * i)) {
                result = true;
                break;
            }
            i++;
        }
        deltaX = 1;
        deltaY = -1;
        i = 1;
        while((source.x + deltaX * i < 8) && (source.y + deltaY * i >= 0)) {
            if (dest.x == (source.x + deltaX * i) && dest.y == (source.y + deltaY * i)) {
                result = true;
                break;
            }
            i++;
        }
        deltaX = -1;
        deltaY = -1;
        i = 1;
        while((source.x + deltaX * i >= 0) && (source.y + deltaY * i >= 0)) {
            if (dest.x == (source.x + deltaX * i) && dest.y == (source.y + deltaY * i)) {
                result = true;
                break;
            }
            i++;
        }
        deltaX = -1;
        deltaY = 1;
        i = 1;
        while((source.x + deltaX * i >= 0) && (source.y + deltaY * i < 8)) {
            if (dest.x == (source.x + deltaX * i) && dest.y == (source.y + deltaY * i)) {
                result = true;
                break;
            }
            i++;
        }
        return result;
    }
}