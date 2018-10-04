package ru.job4j.department;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentSort {

    private List<String> generating(List<String> source) {
        Set<String> set = new TreeSet<>();
        for (String l : source) {
            int count = 0;
            l = l.substring(1, l.length() - 1);
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
        List<String> result = new LinkedList<>();
        Set<String> source4 = new TreeSet<>(new Department());
        source4.addAll(this.generating(source));
        for (String s : source4) {
            result.add("\"" + s + "\"");
        }
        return result;
    }

    public List<String> sort(List<String> source) {
        List<String> result = new LinkedList<>();
        Set<String> source4 = new TreeSet<>(this.generating(source));
        for (String s : source4) {
            result.add("\"" + s + "\"");
        }
        return result;
    }
}