package ru.job4j.srp.engineer.menu;

import ru.job4j.srp.menu.PointMenu;
import ru.job4j.srp.simple.Menu;

import java.util.ArrayList;

public class EngineerMenu extends Menu {
    private static final Menu MENU = new EngineerMenu();

    public static Menu getInstance() {
        return MENU;
    }

    private final ArrayList<PointMenu> points = super.getMenu();

    {
        points.add(new PointMenu(5, "Косинус", "cos"));
        points.add(new PointMenu(6, "Синус", "sin"));
        points.add(new PointMenu(7, "Тангенс", "tg"));
        points.add(new PointMenu(8, "Котангенс", "ctg"));

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
