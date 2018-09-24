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
        for (Map.Entry<User, ArrayList<Account>> entry : this.accounts.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                ArrayList<Account> accs = new ArrayList<>(entry.getValue());
                accs.add(account);
                entry.setValue(accs);
                break;
            }
        }
    }

    public void deleteAccountFromUser(User user, Account account) {
        for (Map.Entry<User, ArrayList<Account>> entry : this.accounts.entrySet()) {
            if (user.equals(entry.getKey())) {
                ArrayList<Account> accs = new ArrayList<>(entry.getValue());
                accs.remove(account);
                entry.setValue(accs);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(User user) {
        return this.accounts.get(user);
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
        Account result = null;
        for (Map.Entry<User, ArrayList<Account>> entry : this.accounts.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                List<Account> accounts = getUserAccounts(entry.getKey());
                for (Account a : accounts) {
                    if (requisites.equals(a.getReqs())) {
                        result = a;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

