package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class UserTest {
    Map<User, Object> userMap = new HashMap<>();
    Calendar dates = new GregorianCalendar(1212, 12, 12);

    @Before
    public void beforeTest() {
        User user1 = new User("Carl", 2, dates);
        User user2 = new User("Carl", 2, dates);
        userMap.put(user1, user1);
        userMap.put(user2, user2);
    }

    @Test
    public void whenAddTwoElementsAndSout() {
        System.out.println(userMap);
    }
}
