package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {
    private double result;
    private static final int dollar = 60 ;
    private static final int euro = 70 ;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(int value) {
        result = value/euro;
        return result;
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public double rubleToDollar(int value) {
        result = value/dollar;
        return result;
    }
        /**
     * Конвертируем евро в рубли.
     * @param value рубли.
     * @return Рубли.
     */
    public double euroToRuble(int value) {
        result = value*euro;
        return result;
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public double dollarToRuble(int value) {
        result = value*dollar;
        return result;
    }
}