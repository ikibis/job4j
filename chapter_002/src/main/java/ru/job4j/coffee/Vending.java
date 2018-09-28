package ru.job4j.coffee;

import java.util.ArrayList;
import java.util.List;

public class Vending {
    private final int[] coins = new int[] {10, 5, 2, 1};
    private List<Integer> result = new ArrayList<>();
    int[] changes(int value, int price) {
        int delivery  = value - price;
        while (delivery  > 0) {
            for (int coin : coins) {
                if (delivery >= coin) {
                    delivery -= coin;
                    result.add(coin);
                    break;
                }
            }
        }
        int[] out = new int[result.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = result.get(i);
        }
        return out;
    }
}