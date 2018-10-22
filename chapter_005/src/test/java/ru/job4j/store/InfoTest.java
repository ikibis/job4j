package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InfoTest {
    Store store = new Store();
    Info info = new Info();

    @Before
    public void beforeTest() {
        store.addUser(1111, "Grisha");
        store.addUser(2222, "Maks");
        store.addUser(3333, "Vitya");
        store.addUser(4444, "Anton");
        store.addUser(5555, "Ivan");
        store.addUser(6666, "Nastya");
    }

    @Test
    public void when6ElThen6New() {
        assertThat(info.howMuchNew(store), is(6));
    }

    @Test
    public void when1SetThen1Setted() {
        store.setUser(1111, "Katya");
        assertThat(info.howMuchSetted(store), is(1));
    }

    @Test
    public void when1RemoveThen1Deleted() {
        store.removeUser(1111);
        assertThat(info.howMuchDeleted(store), is(1));
    }
}


