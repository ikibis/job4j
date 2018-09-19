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
    @Test
    public void whenSortNameLength() {
        List<User> list = new ArrayList<>();
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Ekaterina", 3);
        User thirdUser = new User("Eva", 5);
        User fourUser = new User("Mariya", 3);
        list.add(secondUser);
        list.add(thirdUser);
        list.add(firstUser);
        list.add(fourUser);

        List<User> result = new SortUser().sortNameLength(list);

        List<User> expect = new ArrayList<>();
        expect.add(thirdUser);
        expect.add(firstUser);
        expect.add(fourUser);
        expect.add(secondUser);
        assertThat(result, is(expect));
    }
    @Test
    public void whenSortByAllFields() {
        List<User> list = new ArrayList<>();
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Mark", 3);
        User thirdUser = new User("Eva", 5);
        User fourUser = new User("Eva", 3);
        list.add(secondUser);
        list.add(thirdUser);
        list.add(firstUser);
        list.add(fourUser);

        List<User> result = new SortUser().sortByAllFields(list);
        List<User> expect = new ArrayList<>();
        expect.add(fourUser);
        expect.add(thirdUser);
        expect.add(secondUser);
        expect.add(firstUser);
        
        assertThat(result, is(expect));
    }
}