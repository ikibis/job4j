package ru.job4j.srp.simple;

import ru.job4j.srp.simple.actions.ActionFactory;
import ru.job4j.srp.io.Input;
import ru.job4j.srp.io.Output;
import ru.job4j.srp.io.ValidateInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private final ActionFactory factory;
    private final Menu menu;
    private final ValidateInput validateInput = ValidateInput.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private List<Double> numbersList = new ArrayList<>();

    public Calculator(final ActionFactory factory, final Menu menu) {
        this.factory = factory;
        this.menu = menu;
    }

    public void run() {
        boolean carryOn = true;
        double result = 0;
        int numberOfPointsMenu = menu.getMenu().size();
        while (carryOn) {
            System.out.println("Что вы хотите сделать? Для использования результата предыдущего вычисленя вместо числа введите MR");
            menu.showMenu();
            Input inputOfPointMenu = new Input(scanner.next(), "PointOfMenu");
            Output respOnSelectedPoint = validateInput.check(inputOfPointMenu);
            if (!outputChecker(respOnSelectedPoint)) {
                continue;
            }
            int selectedPoint = Integer.valueOf(respOnSelectedPoint.getValue().toString());
            System.out.println();
            if (selectedPoint == 0) {
                System.out.println("Работа программы завершена");
                carryOn = false;
            } else if (selectedPoint > 0 && selectedPoint <= numberOfPointsMenu) {
                String descOfPointMenu = menu.getDescByPointOfMenuNumber(selectedPoint);
                int numberOfInputs = menu.getNumbersByPointOfMenuNumber(selectedPoint);
                this.prepareNumbersList(numbersList, "fill", numberOfInputs);
                System.out.println("Вы выбрали, " + descOfPointMenu + " --> введите " + numberOfInputs + " числа");
                for (int i = 0; i < numberOfInputs; i++) {
                    Input inputFirsNumber = new Input(scanner.next(), "Number");
                    Output respOnNumber = validateInput.check(inputFirsNumber);
                    if (!outputChecker(respOnNumber)) {
                        continue;
                    }
                    double number = respOnNumber.getValue().equals("MR") ? result : Double.valueOf(respOnNumber.getValue().toString());
                    numbersList.set(i, number);
                }
                result = factory.calculate(menu.getActionByNumber(selectedPoint), numbersList);
                System.out.println("Результат вычисления " + result);
                System.out.println();
                this.prepareNumbersList(numbersList, "clear", 0);
            } else {
                System.out.println("Введите корректный номер пункта меню от 0 до " + numberOfPointsMenu);
            }
        }
    }

    private boolean outputChecker(Output output) {
        boolean result = true;
        if (output.getMessage().equals("error")) {
            System.out.println("Вы ввели некорректные данные, ошибка");
            System.out.println();
            result = false;
        }
        return result;
    }

    private List<Double> prepareNumbersList(List<Double> list, String action, int numberOfInputs) {
        if (action.equals("fill")) {
            for (int i = 0; i < numberOfInputs; i++) {
                list.add(0.0);
            }
        } else if (action.equals("clear")) {
            list.clear();
        }
        return list;
    }
}