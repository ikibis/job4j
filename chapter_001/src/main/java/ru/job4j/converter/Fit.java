package ru.job4j.calculator;

/**
 * ��������� ������� ���������� ����.
 */
public class Fit {
    private double result;
    /**
     * ��������� ��� ��� �������.
     * @param height ����.
     * @return ��������� ���.
     */
    public double manWeight(double height) {
        result = (height - 100)*1.15;
        return result;
    }

    /**
     * ��������� ��� ��� �������.
     * @param height ����.
     * @return ��������� ���.
     */
    public double womanWeight(double height) {
        result = (height - 110)*1.15;
        return result;
    }
}