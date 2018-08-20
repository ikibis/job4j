package ru.job4j.professions;

public class Doctor extends Professions {
    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }
}
