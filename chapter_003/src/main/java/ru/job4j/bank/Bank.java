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
        boolean result;
        double oldValue;
        User userSrc = this.findByPassport(srcPassport);
        int srcNum = findByRequisites(userSrc, srcRequisite);
        User userDest = this.findByPassport(destPassport);
        int destNum = findByRequisites(userDest, dstRequisite);
        if (srcNum != -1 && destNum != -1) {
            oldValue = this.accounts.get(userSrc).get(srcNum).getValue();
            if (oldValue < amount) {
                result = false;
            } else {
                this.accounts.get(userSrc).get(srcNum).setValue(oldValue - amount);
                oldValue = this.accounts.get(userDest).get(destNum).getValue();
                this.accounts.get(userDest).get(destNum).setValue(oldValue + amount);
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    public User findByPassport(String passport) {
        User result = null;
        for (Map.Entry<User, ArrayList<Account>> entry : this.accounts.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public int findByRequisites(User user, String requisites) {
        int result = -1;
        ArrayList<Account> accounts = new ArrayList<>(this.accounts.get(user));
        for (Account a : accounts) {
            if (requisites.equals(a.getReqs())) {
                result = accounts.indexOf(a);
                break;
            }
        }
        return result;
    }
}

