package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenAddUsersAndConvert() {
        User firstUser = new User(12, "Mark", "Ekaterinburg");
        User secondUser = new User(14, "Eva", "Moscow");
        User thirdUser = new User(16, "Ekaterina", "Novouralsk");
        List<User> list = new ArrayList<>();
        list.add(firstUser);
        list.add(secondUser);
        list.add(thirdUser);
        HashMap<Integer, User> result = new UserConvert().process(list);
        HashMap<Integer, User> expect = new HashMap<Integer, User>();
        expect.put(12, firstUser);
        expect.put(14, secondUser);
        expect.put(16, thirdUser);
        assertThat(result, is(expect));
    }
}

