package ru.job4j.problems;

public class Demo {
    public static final class Counter {
        int count = 0;
        public void add(int vaiue) {
            this.count += vaiue;
        }
    }
    public static final class FirstThread extends Thread {
        final Counter counter;
        public FirstThread(Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            counter.add(1);
        }
    }
}
