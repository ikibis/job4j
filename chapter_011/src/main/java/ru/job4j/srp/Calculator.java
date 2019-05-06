package ru.job4j.srp;

import ru.job4j.srp.actions.ActionFactory;
import ru.job4j.srp.io.Input;
import ru.job4j.srp.io.Output;
import ru.job4j.srp.io.ValidateInput;
import ru.job4j.srp.menu.Menu;

import java.util.Scanner;

public class Calculator {
    private final ActionFactory factory = ActionFactory.getInstance();
    private final Menu menu = Menu.getInstance();
    private final ValidateInput validateInput = ValidateInput.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean carryOn = true;
        double firstNumber;
        double secondNumber;
        double result = 0;
        while (carryOn) {
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
            } else if (selectedPoint == 5) {
                carryOn = false;
            } else {
                System.out.println("Введите корректный номер пункта меню от 1 до 6");
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