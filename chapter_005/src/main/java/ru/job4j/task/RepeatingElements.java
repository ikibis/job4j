package ru.job4j.task;

import java.util.Set;
import java.util.TreeSet;

public class RepeatingElements {
    public Set<String> checkRepeat(String word) {
        String[] strToArray = word.split("");
        Set<String> result = new TreeSet<>();
        Set<String> set = new TreeSet<>();
        for (String s : strToArray) {
            if (!set.add(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
