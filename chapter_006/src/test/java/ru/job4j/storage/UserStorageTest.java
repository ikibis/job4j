package ru.job4j.storage;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    UserStorage storage;
    User user1;
    User user2;
    User user3;

    private class ThreadDemo extends Thread {
        private User user1;
        private User user2;
        private ThreadDemo(final User user1, final User user2) {
            this.user1 = user1;
            this.user2 = user2;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                storage.transfer(
                        user1.getIdt(), user2.getIdt(), 10);
            }
        }
    }

    @Before
    public void beforeTest() {
        storage = new UserStorage();
        user1 = new User(1, 100);
        user2 = new User(2, 200);
        user3 = new User(1, 300);
    }

    @Test
    public void whenAdd2Users() {
        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user2), is(true));
        assertThat(storage.add(user2), is(false));
    }

    @Test
    public void whenUpdateUser() {
        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user2), is(true));
        assertThat(storage.update(user3), is(true));
        assertThat(storage.findUser(user3.getIdt()).getAmount(), is(300));
    }

    @Test
    public void whenDeleteUser() {
        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user2), is(true));
        assertThat(storage.delete(user2), is(true));
        assertThat(storage.delete(user2), is(false));
        assertThat(storage.findUser(user2.getIdt()), is(nullValue()));
    }

    @Test
    public void whenTransfer() {
        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user2), is(true));
        assertThat(
                storage.transfer(
                        user2.getIdt(), user1.getIdt(), 150), is(true));
        assertThat(storage.findUser(user2.getIdt()).getAmount(), is(50));
        assertThat(storage.findUser(user1.getIdt()).getAmount(), is(250));
    }

    @Test
    public void whenLoopTransfer() throws InterruptedException {
        assertThat(storage.add(user1), is(true));
        assertThat(storage.add(user2), is(true));
        Thread first = new UserStorageTest.ThreadDemo(user1, user2);
        Thread second = new UserStorageTest.ThreadDemo(user2, user1);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(storage.findUser(user1.getIdt()).getAmount(), is(100));
        assertThat(storage.findUser(user2.getIdt()).getAmount(), is(200));
    }
}
