package ru.job4j.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer l : list) {
            array[i][j] = l;
            j++;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        return list.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

    }
}

