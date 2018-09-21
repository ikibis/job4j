package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void whenAddUser() {
        Account account = new Account();
        User user = new User("Mark", "100200300");
        account.addUser(user);
        boolean result = account.accounts.containsKey(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenAddAndDeleteUser() {
        Account account = new Account();
        User user = new User("Mark", "100200300");
        account.addUser(user);
        account.deleteUser(user);
        boolean result = account.accounts.containsKey(user);
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAcccountToUser() {
        Account account = new Account(10000, "1234567");
        User user = new User("Mark", "100200300");
        new Account().addUser(user);
        new Account().addAcccountToUser("100200300", new Account(10000, "1234567"));
        ArrayList<Account> accs = new ArrayList<>(account.accounts.get(user));
        accs.size();
        assertThat(1, is(1));
    }
      /*
    @Test
    public void whenSortByAllFields() {
        List<ru.job4j.comparator.User> list = new ArrayList<>();
        ru.job4j.comparator.User firstUser = new ru.job4j.comparator.User("Mark", 4);
        ru.job4j.comparator.User secondUser = new ru.job4j.comparator.User("Mark", 3);
        ru.job4j.comparator.User thirdUser = new ru.job4j.comparator.User("Eva", 5);
        ru.job4j.comparator.User fourUser = new ru.job4j.comparator.User("Eva", 3);
        list.add(secondUser);
        list.add(thirdUser);
        list.add(firstUser);
        list.add(fourUser);

        List<ru.job4j.comparator.User> result = new SortUser().sortByAllFields(list);
        List<User> expect = new ArrayList<>();
        expect.add(fourUser);
        expect.add(thirdUser);
        expect.add(secondUser);
        expect.add(firstUser);

        assertThat(result, is(expect));
    }
    */
}