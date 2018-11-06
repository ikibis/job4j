package ru.job4j.task;

import java.util.*;

public class CompareStrings {
    public boolean compare1(String first, String second) {
        boolean result = true;
        char[] strToArray1 = first.toCharArray();
        char[] strToArray2 = second.toCharArray();
        int count = 0;
        if (strToArray1.length == strToArray2.length) {
            for (int i = 0; i < strToArray1.length; i++) {
                int entryCount = count;
                for (int j = 0; j < strToArray2.length; j++) {
                    if (strToArray1[i] == strToArray2[j]) {
                        count++;
                        strToArray2[j] = '*';
                        break;
                    }
                }
                if (entryCount == count) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public boolean compare2(String first, String second) {
        String[] strToArray1 = first.split("");
        String[] strToArray2 = second.split("");
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for (String s : strToArray1) {
            if (map1.containsValue(s)) {
                map1.put(s.hashCode() + 1, s);
            } else {
                map1.put(s.hashCode(), s);
            }
        }
        for (String s : strToArray2) {
            if (map2.containsValue(s)) {
                map2.put(s.hashCode() + 1, s);
            } else {
                map2.put(s.hashCode(), s);
            }
        }
        return map1.equals(map2);
        //  а  смысл? нужно было сразу получить ключ. если нет элемента. то есть тебе надо сделать вот без этой проверки.
                // map1.keySet().containsAll(map2.keySet()) && map2.keySet().containsAll(map1.keySet());
    }
}

