package ru.job4j.lsp.product;

import java.util.Date;

public class Milk extends Food {
    public Milk(String name, Date expireDate, Date createDate, double price, boolean discount) {
        super(name, expireDate, createDate, price, discount);
    }
}

