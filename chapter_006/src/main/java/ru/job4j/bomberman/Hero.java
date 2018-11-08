package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    Cell position;

    public Hero(Cell position) {
        this.position = position;
    }

    public List<Cell> way() {
        List<Cell> steps = new ArrayList<>();
        int index = -1;
        while (index < 2) {
            Cell turnX = Cell.find(position.x + index, position.y);
            steps.add(turnX);
            Cell turnY = Cell.find(position.x, position.y + index);
            steps.add(turnY);
            index += 2;
        }
        return steps;
    }
}
