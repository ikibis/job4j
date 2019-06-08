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
        List<User> list = List.of(
                firstUser,
                secondUser,
                thirdUser
        );
        Map<Integer, User> result = new UserConvert().process(list);
        Map<Integer, User> expect = Map.of(
                12, firstUser,
                14, secondUser,
                16, thirdUser
        );
        assertThat(result, is(expect));
    }
}

