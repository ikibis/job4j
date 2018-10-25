package ru.job4j.problems;

public class FirstThread extends Thread {
    Simple s;

    public FirstThread(Simple s) {
        this.s = s;
        new Thread().start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            s.word = s.word + " " + i + " FT ";
            System.out.println(s.word);
        }
    }
}
