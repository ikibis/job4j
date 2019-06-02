package ru.job4j.gc;

public class User {

    public String name;

   /* public User(String name) {
        this.name = name;
    }*/

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("FINALIZE");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
