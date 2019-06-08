package ru.job4j.students;

public class Student {

    private int score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}