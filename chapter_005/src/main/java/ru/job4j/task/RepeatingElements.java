package ru.job4j.task;

import java.util.Set;
import java.util.TreeSet;

public class RepeatingElements {
    public Set<Character> checkRepeat(String word) {
        char[] strToArray = word.toCharArray();
        Set<Character> result = new TreeSet<>();
        Set<Character> set = new TreeSet<>();
        for (char s : strToArray) {
            if (!set.add(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
