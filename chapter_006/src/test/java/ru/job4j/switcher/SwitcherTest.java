package ru.job4j.switcher;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SwitcherTest {
    Switcher switcher;

    private class ThreadOne extends Thread {
        Switcher switcher;

        private ThreadOne(final Switcher switcher) {
            this.switcher = switcher;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                switcher.setText(1);
            }
        }
    }

    private class ThreadTwo extends Thread {
        Switcher switcher;

        private ThreadTwo(final Switcher switcher) {
            this.switcher = switcher;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                switcher.setText(2);
            }
        }
    }

    @Before
    public void beforeTest() {
        switcher = new Switcher("");
    }

    @Test
    public void when2Threads() throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            Thread threadOne = new ThreadOne(switcher);
            Thread threadTwo = new ThreadTwo(switcher);
            threadOne.start();
            threadOne.join();
            threadTwo.start();
            threadTwo.join();
        }
        System.out.println(switcher.getText());
        assertThat(switcher.getText(), is("1111111111222222222211111111112222222222111111111122222222221111111111222222222211111111112222222222"));
    }
}
