package ru.job4j.email;

public class User {
    private String name;
    private String email;


    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
