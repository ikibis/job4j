package ru.job4j.tracker;

import java.util.List;
/**
 * Класс, для взаимодействия с пользователем.
 */
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
    public StartUI(final Input input, final Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public final void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = menu.fillActions(menu, this);
        do {
            menu.show(result -> System.out.println(result));
            menu.select(input.ask("select:", range));
        } while (this.working);
    }
    /**
     * Метод для остановки программы.
     */
    public final void stop() {
        this.working = false;
    }
    /**
     * Запускт программы.
     * @param args аргументы
     */
    public static void main(final String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}

