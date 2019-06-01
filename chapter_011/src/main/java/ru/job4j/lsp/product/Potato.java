package ru.job4j.lsp.product;

import java.util.Date;

public class Potato extends Food implements Recycling {
    public Potato(String name, Date expireDate, Date createDate, double price, boolean discount) {
        super(name, expireDate, createDate, price, discount);
    }

    @Override
    public boolean isCanRecycling() {
        return true;
    }
}
