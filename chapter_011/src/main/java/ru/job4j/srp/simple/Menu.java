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
        points.add(new PointMenu(0, "Выйти", "exit", 0));
        points.add(new PointMenu(1, "Сложить", "+", 2));
        points.add(new PointMenu(2, "Вычесть", "-", 2));
        points.add(new PointMenu(3, "Умножить", "*", 2));
        points.add(new PointMenu(4, "Разделить", "/", 2));
    }

    public ArrayList<PointMenu> getMenu() {
        return this.points;
    }

    public String getDescByPointOfMenuNumber(int number) {
        return points.get(number).getDescription();
    }

    public int getNumbersByPointOfMenuNumber(int number) {
        return points.get(number).getNumbers();
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
