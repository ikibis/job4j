package ru.job4j.threadsafe;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
@ThreadSafe
public class SafetyListTest {
    @GuardedBy("this")
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
            while (it.hasNext()) {
                sum += it.next();
            }
        }
    }

    @Before
    public void beforeTest() {
        list = new SafetyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenIteratorToSum() throws InterruptedException {
        Thread first = new SafetyListTest.ThreadDemo(list);
        Thread second = new SafetyListTest.ThreadDemo(list);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(sum, is(20));
    }
}
