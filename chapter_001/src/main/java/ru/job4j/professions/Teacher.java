package ru.job4j.professions;

public class Teacher extends Professions {
    public Diploma give(Student student) {
        return new Diploma();
    }
}
