package ru.job4j.problems;

public class SecondThread extends Thread {
    Simple s;

    public SecondThread(Simple s) {
        this.s = s;
        new Thread().start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            s.word = s.word + " " + i + " ST ";
            System.out.println(s.word);
        }
    }
}