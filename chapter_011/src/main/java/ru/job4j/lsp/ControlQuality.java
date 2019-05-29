package ru.job4j.lsp;

import ru.job4j.lsp.product.Food;
import ru.job4j.lsp.storage.*;

import java.util.Date;

public class ControlQuality {

    public void productGrader(Food food) {
        double expiration = this.getExpiration(food);
        Storage storage = this.getStorage(expiration, food);
        storage.add(food);
    }

    public Storage getStorage(double expiration, Food food) {
        Storage result = null;
        if (expiration < 0.25) {
            result = new Warehouse();
        } else if (expiration > 0.25 && expiration < 0.75) {
            result = new Shop();
        } else if (expiration > 0.75 && expiration < 1) {
            food.setDiscount(true);
            result = new Shop();
        } else if (expiration >= 1) {
            result = new Trash();
        }
        return result;
    }

    private double getExpiration(Food food) {
        long createDate = food.getCreateDate().getTime();
        long expireDate = food.getExpireDate().getTime();
        long currentDate = new Date().getTime();
        return (currentDate - createDate) / (createDate - expireDate);
    }
}
