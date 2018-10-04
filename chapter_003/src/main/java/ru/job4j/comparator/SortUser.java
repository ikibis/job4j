package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }
    public List<User> sortNameLength(List<User> users) {
        Comparator comp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        };
        return (List<User>) users.stream()
                .sorted(comp)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public List<User> sortByAllFields(List<User> users) {
        Comparator comp = new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int flag = o1.getName().compareTo(o2.getName());
                        if (flag == 0) {
                            flag = Integer.compare(o1.getAge(), (o2.getAge()));
                        }
                        return flag;
                    }
                };
        return (List<User>) users.stream()
                .sorted(comp)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
