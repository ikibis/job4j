package ru.job4j.bank;

import java.util.*;

public class Account {

    private double value;
    private String requisites;

    public Account() {
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getReqs() {
        return this.requisites;
    }

    public TreeMap<User, ArrayList<Account>> accounts = new TreeMap<>();

    public void addUser(User user) {
        ArrayList<Account> accs = new ArrayList<>();
        this.accounts.put(user, accs);
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    public void addAcccountToUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : this.accounts.entrySet()) {
            System.out.println("Я в цикле Map.Entry");
            if (passport.equals(entry.getKey().getPassport())) {
                ArrayList<Account> accs = new ArrayList<>(entry.getValue());
                accs.add(account);
                entry.setValue(accs);
                break;
            }
        }
    }
/*
    public void deleteAccountFromUser(User user, Account account) {
        this.accounts.get(user).remove(account);
    }

    public List<Account> getUserAccounts(User user) {
        return this.accounts.get(user);
    }

    public boolean transferMoney(User user1, Account account1,
                                 User user2, Account account2, double amount) {
        return this.accounts.get(user1).contains(account1)
                && this.accounts.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }*/
}

