package ru.job4j.srp.simple;

import ru.job4j.srp.menu.PointMenu;

import java.util.ArrayList;

public class Menu {
    private static final Menu MENU = new Menu();

    public static Menu getInstance() {
        return MENU;
    }

    private final ArrayList<PointMenu> points = new ArrayList<>();

    {
        points.add(new PointMenu(0, "Выйти", "exit"));
        points.add(new PointMenu(1, "Сложить", "+"));
        points.add(new PointMenu(2, "Вычесть", "-"));
        points.add(new PointMenu(3, "Умножить", "*"));
        points.add(new PointMenu(4, "Разделить", "/"));
    }

    public ArrayList<PointMenu> getMenu() {
        return this.points;
    }

    public String getDescByNumber(int number) {
        return points.get(number).getDescription();
    }

    public void showMenu() {
        for (PointMenu point : points) {
            System.out.println(point.getNumber() + ". " + point.getDescription());
        }
    }

    public String getActionByNumber(int number) {
        return points.get(number).getAction();
    }
}
