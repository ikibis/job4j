package ru.job4j.pool;

import org.junit.Test;

public class ThreadPoolTest {

    @Test
    public void whenAddTenJobsThenWork() {
        ThreadPool pool = new ThreadPool();

        for (int index = 0; index < 100; index++) {
            pool.work(new Job());
        }
        pool.shutdown();

    }
}
