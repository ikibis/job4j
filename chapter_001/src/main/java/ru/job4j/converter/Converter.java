package ru.job4j.converter;

/**
 * ��������� ������.
 */
public class Converter {
    private double result;
    final int dollar = 60 ;
    final int euro = 70 ;
    /**
     * ������������ ����� � ����.
     * @param value �����.
     * @return ����.
     */
    public int rubleToEuro(int value) {
        result = value/euro;
        return result;
    }
    /**
     * ������������ ����� � �������.
     * @param value �����.
     * @return �������
     */
    public int rubleToDollar(int value) {
        result = value/dollar;
        return result;
    }
        /**
     * ������������ ���� � �����.
     * @param value �����.
     * @return �����.
     */
    public int euroToRuble(int value) {
        result = value*euro;
        return result;
    }
    /**
     * ������������ ������� � �����.
     * @param value �������.
     * @return �����.
     */
    public int dollarToRuble(int value) {
        result = value*dollar;
        return result;
    }
}