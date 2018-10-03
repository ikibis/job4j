package ru.job4j.department;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentSort {

    public List<String> generating(List<String> source) {
        Set<String> set = new TreeSet<>();
        for (String l : source) {
            int count = 0;
            String result = "";
            for (String s : l.split("\\\\")) {
                if (count == 0) {
                    result += s;
                    set.add(result);
                    count++;

                } else {
                    result += "\\" + s;
                    set.add(result);
                }
            }
        }
        return new LinkedList<>(set);
    }

    public List<String> reverse(List<String> source) {
        Set<String> result = new TreeSet<>(new Department());
        result.addAll(this.generating(source));
        return new LinkedList<>(result);
    }
}