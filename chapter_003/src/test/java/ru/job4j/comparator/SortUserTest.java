package ru.job4j.comparator;

import org.junit.Test;

import java.util.Set;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddUsersAndConvert() {
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Mark", 3);
        User thirdUser = new User("Eva", 5);
        List<User> list = List.of(secondUser, thirdUser, firstUser);
        Set<User> result = new SortUser().sort(list);
        Set<User> expect = Set.of(secondUser, thirdUser, firstUser);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortNameLength() {
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Ekaterina", 3);
        User thirdUser = new User("Eva", 5);
        User fourUser = new User("Mariya", 3);
        List<User> list = List.of(secondUser, thirdUser, firstUser, fourUser);
        List<User> result = new SortUser().sortNameLength(list);
        List<User> expect = List.of(thirdUser, firstUser, fourUser, secondUser);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortByAllFields() {
        User firstUser = new User("Mark", 4);
        User secondUser = new User("Mark", 3);
        User thirdUser = new User("Eva", 5);
        User fourUser = new User("Eva", 3);
        List<User> list = List.of(secondUser, thirdUser, firstUser, fourUser);
        List<User> result = new SortUser().sortByAllFields(list);
        List<User> expect = List.of(fourUser, thirdUser, secondUser, firstUser);
        assertThat(result, is(expect));
    }
}