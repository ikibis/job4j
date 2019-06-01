package ru.job4j.lsp.product;

import java.util.Date;

public class Food implements Recycling, Vegetable {
    private String name;
    private Date expireDate;
    private Date createDate;
    private double price;
    private boolean discount;

    public Food(String name, Date expireDate, Date createDate, double price, boolean discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public boolean isCanRecycling() {
        return false;
    }

    @Override
    public boolean isVegetable() {
        return false;
    }
}
