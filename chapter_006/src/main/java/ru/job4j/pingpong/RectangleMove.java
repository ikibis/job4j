package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int step = 0;
        while (true) {
            if (this.rect.getX() >= 250) {
                step = -5;
            }
            if (this.rect.getX() <= 50) {
                step = 5;
            }
            this.rect.setX(this.rect.getX() + step);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
