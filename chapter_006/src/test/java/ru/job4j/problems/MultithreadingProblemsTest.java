package ru.job4j.problems;

import org.junit.Test;

public class MultithreadingProblemsTest {
    Simple s = new Simple();
    @Test
    public void whenTwoThreads() {
        new FirstThread(s).start();
        new SecondThread(s).start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
