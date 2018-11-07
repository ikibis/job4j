package ru.job4j.pool;

import ru.job4j.buffer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private final List<Thread> threads = new LinkedList<>();
    int size = Runtime.getRuntime().availableProcessors();

    public ThreadPool() {
        for (int i = 0; i < size; i++) {
            threads.add(new TasksPool(tasks));
        }
    }

    public void work(Runnable job) {
        try {
            tasks.offer(job);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

/*

              1. Инициализация пула должна быть по количеству ядер в системе.
              int size = Runtime.getRuntime().availableProcessors()
В каждую нить передается блокирующая очередь tasks.
Количество нитей всегда одинаковое и равно size.
В методе run мы должны получить задачу их очереди tasks.
tasks - это блокирующая очередь. Если в очереди нет элементов, то нить переводиться в состоянии waiting.
Когда приходит новая задача, всем нитям в состоянии waiting посылается сигнал проснуться и начать работу.
2. Создать метод work(Runnable job). - этот метод должен добавлять задачи в блокирующую очередь tasks.

у тебя должно быть два хранилища в одном потоки запущенные тредпулом и второе это задачи в тобой написанной очереди
потоки должны брать задачи и запускать их
 */