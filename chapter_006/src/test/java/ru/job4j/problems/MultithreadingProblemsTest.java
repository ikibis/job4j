package ru.job4j.problems;

import org.junit.Test;

public class MultithreadingProblemsTest {
    Demo.Counter counter = new Demo.Counter();
    Thread treadA = new Demo.FirstThread(counter);
    Thread treadB = new Demo.FirstThread(counter);
    @Test
    public void whenTwoThreads() throws InterruptedException {
        treadA.start();
        treadB.start();
        //treadA.join();
        //treadB.join();
        System.out.println(counter.count);
    }
}
