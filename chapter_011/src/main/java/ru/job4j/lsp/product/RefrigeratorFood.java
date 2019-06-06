package ru.job4j.lsp.product;

import java.util.Date;

public class RefrigeratorFood extends CanRecyclingFood implements Vegetable {
    private boolean isVegetable;

    public RefrigeratorFood(String name, Date expireDate, Date createDate, double price, boolean discount, boolean canRecycling, boolean isVegetable) {
        super(name, expireDate, createDate, price, discount, canRecycling);
        this.isVegetable = isVegetable;
    }

    @Override
    public boolean isVegetable() {
        return this.isVegetable;
    }
}