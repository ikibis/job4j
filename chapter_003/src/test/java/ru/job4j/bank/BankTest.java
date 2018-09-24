package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("Mark", "100200300");
        bank.addUser(user);
        boolean result = bank.accounts.containsKey(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenAddAndDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Mark", "100200300");
        bank.addUser(user);
        bank.deleteUser(user);
        boolean result = bank.accounts.containsKey(user);
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        Account account = new Account(10000, "1234567");
        User user = new User("Mark", "100200300");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        String result = bank.accounts.get(user).get(0).getReqs();
        assertThat(account.getReqs(), is(result));
    }

    @Test
    public void whenAddAndDeleteAccountFromUser() {
        Bank bank = new Bank();
        Account account = new Account(10000, "1234567");
        User user = new User("Mark", "100200300");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteAccountFromUser(user, account);
        int result = bank.accounts.get(user).size();
        assertThat(0, is(result));
    }

    @Test
    public void whenAddAndFindAccountFromUser() {
        Bank bank = new Bank();
        Account accountOne = new Account(10000, "1234567");
        Account accountTwo = new Account(20000, "89101112");
        User user = new User("Mark", "100200300");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), accountOne);
        bank.addAccountToUser(user.getPassport(), accountTwo);
        bank.getUserAccounts(user);
        List<Account> result = bank.accounts.get(user);
        List<Account> expect = new ArrayList<>();
        expect.add(accountOne);
        expect.add(accountTwo);
        assertThat(expect, is(result));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();

        User userOne = new User("Mark", "100200300");
        Account accountOne = new Account(10000, "1234567");
        User userTwo = new User("Eva", "400500600");
        Account accountTwo = new Account(20000, "89101112");

        bank.addUser(userOne);
        bank.addAccountToUser("100200300", accountOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("400500600", accountTwo);
        boolean result = bank.transferMoney(userOne.getPassport(), accountOne.getReqs(),
                                             userTwo.getPassport(), accountTwo.getReqs(), 1000);

        assertThat(accountTwo.getValue(), is(21000.0));
        assertThat(result, is(true));
    }
}