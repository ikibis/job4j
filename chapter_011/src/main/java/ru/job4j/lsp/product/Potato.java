package ru.job4j.lsp.product;

import java.util.Date;

public class Potato extends CanRecyclingFood {

    public Potato(String name, Date expireDate, Date createDate, double price, boolean discount, boolean canRecycling) {
        super(name, expireDate, createDate, price, discount, canRecycling);
    }
}
