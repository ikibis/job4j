package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = new HashMap();
        list.forEach(
                x -> result.put(x.getId(), x));
        return result;
    }
}
