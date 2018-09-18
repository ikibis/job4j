package ru.job4j.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddUsersAndConvert() {
        List<User> list = new ArrayList<>();
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Mark", 3);
        User thirdUser = new User("Eva", 5);
        list.add(secondUser);
        list.add(thirdUser);
        list.add(firstUser);

        Set<User> result = new SortUser().sort(list);

        Set<User> expect = new TreeSet<>();
        expect.add(firstUser);
        expect.add(thirdUser);
        expect.add(secondUser);
        assertThat(result, is(expect));
    }
}