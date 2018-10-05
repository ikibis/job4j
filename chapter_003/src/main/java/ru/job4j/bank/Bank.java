package ru.job4j.bank;

import java.util.*;

public class Bank {
    public HashMap<User, ArrayList<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        ArrayList<Account> accs = new ArrayList<>();
        this.accounts.put(user, accs);
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.accounts.entrySet().stream()
                .filter(x -> passport.equals(x.getKey().getPassport()))
                .map(Map.Entry::getValue)
                .forEach(x -> x.add(account));
    }

    public void deleteAccountFromUser(User user, Account account) {
        this.accounts.entrySet().stream()
                .filter(x -> user.equals(x.getKey()))
                .map(Map.Entry::getValue)
                .forEach(x -> x.remove(account));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account accountSrc = this.find(srcPassport, srcRequisite);
        Account accountDst = this.find(destPassport, dstRequisite);
        if (accountSrc != null && accountDst != null && accountSrc.getValue() > amount) {
            accountSrc.setValue(accountSrc.getValue() - amount);
            accountDst.setValue(accountDst.getValue() + amount);
            result = true;
        }
        return result;
    }

    public Account find(String passport, String requisites) {
        return this.accounts.entrySet().stream()
                .filter(a -> passport.equals(a.getKey().getPassport()))
                .findFirst().get().getValue()
                .stream()
                .filter(Objects::nonNull)
                .filter(a -> requisites.equals(a.getReqs()))
                .findFirst()
                .orElse(null);
    }
}

