package ru.job4j.converter;
/**
 * Корвертор валюты.
 */
public class Converter {
    /**
     * Курс доллара.
     */
    private static final int DOLLAR = 60;
    /**
     * Курс евро.
     */
    private static final int EURO = 70;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        return value / EURO;
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public double rubleToDollar(int value) {
        return value / DOLLAR;
    }
        /**
     * Конвертируем евро в рубли.
     * @param value рубли.
     * @return Рубли.
     */
    public double euroToRuble(int value) {
        return value * EURO;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public double dollarToRuble(int value) {
        return value * DOLLAR;
    }
}

