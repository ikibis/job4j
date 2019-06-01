package ru.job4j.isp;

import ru.job4j.isp.io.Input;
import ru.job4j.isp.io.Output;
import ru.job4j.isp.io.ValidateInput;

import java.util.List;
import java.util.Scanner;

public class Program {
    private final ValidateInput validateInput = ValidateInput.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = Menu.getInstance();
    private final Storage storage = Storage.getInstance();

    public void run() {
        boolean carryOn = true;
        int numberOfPointsMenu = menu.getMenu().size();
        while (carryOn) {
            System.out.println("Что вы хотите сделать?");
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
                System.out.println("Вы выбрали, " + descOfPointMenu);
                if (selectedPoint == 1) {
                    System.out.println(" --> введите название задачи");
                    String itemName = scanner.next();
                    System.out.println(" --> введите номер родительской задачи, если это основная задача введите 0");
                    Input inputItemNumber = new Input(scanner.next(), "ItemNumber");
                    Output respOnItemNumber = validateInput.check(inputItemNumber);
                    if (!outputChecker(respOnItemNumber)) {
                        continue;
                    }
                    storage.addItem(itemName, respOnItemNumber.getValue().toString());
                }
                if (selectedPoint == 2) {
                    storage.showItems();
                }

            } else {
                System.out.println("Введите корректный номер пункта меню от 0 до " + numberOfPointsMenu);
                System.out.println();
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