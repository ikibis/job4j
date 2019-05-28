package ru.job4j.srp.engineer;

import ru.job4j.srp.engineer.menu.EngineerMenu;
import ru.job4j.srp.simple.actions.ActionFactory;
import ru.job4j.srp.engineer.actions.EngineerActionFactory;
import ru.job4j.srp.io.Input;
import ru.job4j.srp.io.Output;
import ru.job4j.srp.io.ValidateInput;
import ru.job4j.srp.simple.Menu;
import ru.job4j.srp.simple.Calculator;

import java.util.Scanner;

public class EngineerCalculator extends Calculator {
    private final ActionFactory factory = EngineerActionFactory.getInstance();
    private final Menu menu = EngineerMenu.getInstance();
    private final ValidateInput validateInput = ValidateInput.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        boolean carryOn = true;
        double firstNumber;
        double secondNumber;
        double result = 0;
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
            if (selectedPoint > 0 && selectedPoint <= 4) {
                System.out.println("Вы выбрали, " + menu.getDescByNumber(selectedPoint) + " -> введите два числа");

                Input inputFirsNumber = new Input(scanner.next(), "FirstNumber");
                Output respOnFirstNumber = validateInput.check(inputFirsNumber);
                if (!outputChecker(respOnFirstNumber)) {
                    continue;
                }
                firstNumber = respOnFirstNumber.getValue().equals("MR") ? result : Double.valueOf(respOnFirstNumber.getValue().toString());

                Input inputSecondNumber = new Input(scanner.next(), "SecondNumber");
                Output respOnSecondNumber = validateInput.check(inputSecondNumber);
                if (!outputChecker(respOnSecondNumber)) {
                    continue;
                }
                secondNumber = respOnSecondNumber.getValue().equals("MR") ? result : Double.valueOf(respOnSecondNumber.getValue().toString());

                result = factory.calculate(menu.getActionByNumber(selectedPoint), firstNumber, secondNumber);
                System.out.println("Результат вычисления " + result);
                System.out.println();
            } else if (selectedPoint > 4 && selectedPoint <= 8) {
                System.out.println("Вы выбрали, " + menu.getDescByNumber(selectedPoint) + " -> введите число");

                Input inputFirsNumber = new Input(scanner.next(), "FirstNumber");
                Output respOnFirstNumber = validateInput.check(inputFirsNumber);
                if (!outputChecker(respOnFirstNumber)) {
                    continue;
                }
                firstNumber = respOnFirstNumber.getValue().equals("MR") ? result : Double.valueOf(respOnFirstNumber.getValue().toString());

                result = factory.calculate(menu.getActionByNumber(selectedPoint), firstNumber, 0);
                System.out.println("Результат вычисления " + result);
                System.out.println();
            } else if (selectedPoint == 0) {
                carryOn = false;
            } else {
                System.out.println("Введите корректный номер пункта меню от 1 до 8");
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
}
