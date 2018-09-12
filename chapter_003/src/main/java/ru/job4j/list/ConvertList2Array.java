package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        List<Integer> list2 = new ArrayList<>(list);
        int cells = list.size() % rows == 0 ? rows : list.size() / rows + 1;
        int k = rows * cells - list.size();
        while (k > 0) {
            list2.add(0);
            k--;
        }
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer l : list2) {
            array[i][j] = l;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }
}

