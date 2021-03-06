package ru.job4j.comparator;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(age, o.getAge());
    }
}
