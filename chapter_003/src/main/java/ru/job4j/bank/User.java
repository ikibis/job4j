package ru.job4j.bank;

public class User implements Comparable<User>  {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }
    public String getPassport() {
        return this.passport;
    }

    @Override
    public int compareTo(User o) {
        return passport.compareTo(o.getPassport());
    }
}
