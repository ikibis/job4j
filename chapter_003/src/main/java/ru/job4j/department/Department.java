package ru.job4j.department;

import java.util.*;

public class Department implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int count = left.length() <= right.length() ? left.length() : right.length();
        for (int i = 0; i < count; i++) {
            result = (-1) * Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}

