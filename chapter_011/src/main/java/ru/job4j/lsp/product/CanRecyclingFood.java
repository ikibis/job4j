package ru.job4j.lsp.product;

import java.util.Date;

public class CanRecyclingFood extends Food implements Recycling {
    private boolean canRecycling;

    public CanRecyclingFood(String name, Date expireDate, Date createDate, double price, boolean discount, boolean canRecycling) {
        super(name, expireDate, createDate, price, discount);
        this.canRecycling = canRecycling;
    }

    @Override
    public boolean isCanRecycling() {
        return this.canRecycling;
    }
}

