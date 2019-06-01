package ru.job4j.isp;

import java.util.ArrayList;

public class Menu {
    private static final Menu MENU = new Menu();

    public static Menu getInstance() {
        return MENU;
    }

    private final ArrayList<PointMenu> points = new ArrayList<>();

    {
        points.add(new PointMenu(0, "Выйти", "exit"));
        points.add(new PointMenu(1, "Добавить задачу", "add"));
        points.add(new PointMenu(2, "Вывести дерево задач", "show"));
    }

    public ArrayList<PointMenu> getMenu() {
        return this.points;
    }

    public String getDescByPointOfMenuNumber(int number) {
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
