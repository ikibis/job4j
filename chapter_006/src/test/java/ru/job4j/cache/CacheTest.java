package ru.job4j.cache;

import org.junit.Before;
import org.junit.Test;

public class CacheTest {

    Cache cache;
    Thread producer;
    Thread firstConsumer;
    Thread secondConsumer;

    private class DataAddThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 16; i++) {
                String name = i + " name";
                cache.add(new Base(i, name));
            }
        }
    }

    private class DataSetThreadOne extends Thread {
        @Override
        public void run() throws OptimisticException {
            for (int i = 0; i < 16; i++) {
                Base element = (Base) cache.get(i);
                String name = i + " ThreadOne";
                cache.update(new Base(element.getId(), name));
            }
        }
    }

    private class DataSetThreadTwo extends Thread {
        @Override
        public void run() throws OptimisticException {
            for (int i = 0; i < 16; i++) {
                Base element = (Base) cache.get(i);
                String name = i + " ThreadTwo";
                cache.update(new Base(element.getId(), name));
            }
        }
    }

    @Before
    public void beforeTest() {
        cache = new Cache();
        producer = new DataAddThread();
        firstConsumer = new DataSetThreadOne();
        secondConsumer = new DataSetThreadTwo();
    }

    @Test
    public void when3Threads() throws InterruptedException {
        producer.start();
        firstConsumer.start();
        secondConsumer.start();
        firstConsumer.join();
        secondConsumer.join();
        for (int i = 0; i < 16; i++) {
            Base element = (Base) cache.get(i);
            System.out.println("Version " + element.getVersion() + ", Name : " + element.getName());
        }
    }
}

