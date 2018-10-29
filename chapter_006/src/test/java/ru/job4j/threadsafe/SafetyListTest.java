package ru.job4j.threadsafe;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.DynamicArrayList;
import java.util.Iterator;

public class SafetyListTest<T> {
    Iterator<Integer> it;
    SafetyList<Integer> list;
    int sum = 0;
    private class ThreadDemo extends Thread {
        private final SafetyList list;

        private ThreadDemo(final SafetyList list) {
            this.list = list;
        }

        @Override
        public synchronized void run() {
            it = list.iterator();
            while (it.hasnext()) {
                sum += it.next();
            }
        }
    }

    @Before
    public void beforeTest() {
        list = new SafetyList<>();

        list.add(1);
    }

    @Test
    public void whenIteratorToSum() throws InterruptedException {
        Thread first = new SafetyListTest.ThreadDemo(list);
        Thread second = new SafetyListTest.ThreadDemo(list);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
