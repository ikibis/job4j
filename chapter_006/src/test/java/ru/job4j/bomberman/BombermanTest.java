package ru.job4j.bomberman;

import org.junit.Test;

public class BombermanTest {
    @Test
    public void when2Threads() {
        Game game = new Game(4, 0);
        game.gameStart();
    }
}
