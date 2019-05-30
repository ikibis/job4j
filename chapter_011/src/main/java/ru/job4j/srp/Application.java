package ru.job4j.srp;

import ru.job4j.ocp.engineer.EngineerCalculator;
import ru.job4j.ocp.engineer.actions.EngineerActionFactory;
import ru.job4j.ocp.engineer.menu.EngineerMenu;
import ru.job4j.srp.simple.Calculator;
import ru.job4j.srp.simple.Menu;
import ru.job4j.srp.simple.actions.ActionFactory;

public class Application {

    /*private static final ActionFactory FACTORY = ActionFactory.getInstance();
    private static final Menu MENU = Menu.getInstance();*/

    private static final ActionFactory FACTORY = EngineerActionFactory.getInstance();
    private static final Menu MENU = EngineerMenu.getInstance();

    public static void main(String[] args) {
        new EngineerCalculator(FACTORY, MENU).run();
        //new Calculator(FACTORY, MENU).run();
    }
}