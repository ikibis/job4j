package ru.job4j.gc;

public class MemoryUsage {

    public static void main(String[] args) {
        System.out.println("Start");
        // MemoryInfo.getInfo();
        // -Xmx3m
        for (int i = 0; i < 130772; i++) {
            User user = new User("one");
            user = null;
        }
        //System.out.println(user);

        //System.gc();
        System.out.println("Finish");
        // MemoryInfo.getInfo();
    }
}
