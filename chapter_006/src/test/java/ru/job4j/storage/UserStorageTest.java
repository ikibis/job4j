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
}
