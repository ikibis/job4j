package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }
    public Figure3T(final boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }
    public void take(final boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }
    public boolean hasMarkX() {
        return this.markX;
    }
    public boolean hasMarkO() {
        return this.markO;
    }
}

