package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap();
        for (User l: list) {
            result.put(l.getId(), new User(l.getName(), l.getCity()));
        }
        return result;
    }
}
