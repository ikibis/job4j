package ru.job4j.comparator;

import java.util.*;


public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }
    public List<User> sortNameLength(List<User> users) {
        //List<User> result = new ArrayList<>(users);
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                         return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
         );
        return users;
    }
    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int flag = o1.getName().compareTo(o2.getName());
                        if (flag == 0) {
                            flag = Integer.compare(o1.getAge(), (o2.getAge()));
                        }
                        return flag;
                    }
                }
        );
        return users;
    }
}
