package ru.job4j.tracker;

import java.util.*;

public class StartUI {
    /**
     * Программа работает пока значение истинно.
     */
    private boolean working = true;
    /**
     * Получение данных от пользователя.
     */
    private  Input input;
    /**
     * Хранилище заявок.
     */
    private  Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = menu.fillActions(menu, this);
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (this.working);
    }
    public void stop() {
        this.working = false;
    }
    /**
     * Запускт программы.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}

