package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser  {
    public Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        for (User u : users) {
            result.add(u);
        }
        return result;
    }

}
