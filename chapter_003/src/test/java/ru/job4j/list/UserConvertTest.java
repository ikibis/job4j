package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenAddUsersAndConvert() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Mark","Ekaterinburg"));
        list.add(new User(2, "Eva","Moscow"));
        list.add(new User(3, "Ekaterina","Novouralsk"));
        HashMap<Integer, User> result = new UserConvert().process(list);
        HashMap<Integer, User> expect = new HashMap<Integer, User>();
        expect.put(1, new User("Mark","Ekaterinburg"));
        expect.put(2, new User("Eva","Moscow"));
        expect.put(3, new User("Ekaterina","Novouralsk"));
        assertThat(result, is(expect));
    }
}

