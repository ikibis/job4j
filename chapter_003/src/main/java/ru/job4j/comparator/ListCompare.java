package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        int count = left.length() <= right.length() ? left.length() : right.length();
        for (int i = 0; i < count; i++) {
            result += Character.compare(left.charAt(i), right.charAt(i));
        }
        return result;
    }
}