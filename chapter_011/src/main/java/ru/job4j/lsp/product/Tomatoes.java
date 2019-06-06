package ru.job4j.lsp.product;

import java.util.Date;

public class Tomatoes extends RefrigeratorFood {

    public Tomatoes(String name, Date expireDate, Date createDate, double price, boolean discount, boolean canRecycling, boolean isVegetable) {
        super(name, expireDate, createDate, price, discount, canRecycling, isVegetable);
    }

    @Override
    public boolean isVegetable() {
        return true;
    }
}
