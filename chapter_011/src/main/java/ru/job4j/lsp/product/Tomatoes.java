package ru.job4j.lsp.product;

import java.util.Date;

public class Tomatoes extends Food implements Recycling, Vegetable {
    public Tomatoes(String name, Date expireDate, Date createDate, double price, boolean discount) {
        super(name, expireDate, createDate, price, discount);
    }

    @Override
    public boolean isCanRecycling() {
        return true;
    }

    @Override
    public boolean isVegetable() {
        return true;
    }
}
