package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс, описывающий меню и работу пользователя с ним.
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private final ITracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     * @param input объект с введенными данными
     * @param tracker объект
     */
    public MenuTracker(final Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public final int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив и возвращает его.
     * @param menu объект MenuTracker
     * @param ui используется для выхожа из программы
     * @return массив типа UserAction.
     */
    public final List<Integer> fillActions(
            final MenuTracker menu, final StartUI ui) {
        this.actions.add(new MenuTracker.AddItem(0, "Add new Item"));
        this.actions.add(new MenuTracker.ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new MenuTracker.FindItemById(4, "Find item by Id"));
        this.actions.add(new MenuTracker.FindItemsByName(
            5, "Find items by name"));
        this.actions.add(new MenuTracker.ExitProgram(6, "Exit Program", ui));
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(actions.get(i).key());
        }
        return range;
    }
    /**
     * Класс, добавляет новую заявку.
     */
    public class AddItem extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public AddItem(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : "
                    + item.getId());
            System.out.println("------------ New Item with Name : "
                    + item.getName());
            System.out.println("------------ New Item with Description : "
                    + item.getDescription());
        }
    }
    /**
     * Класс, выводит все заявки.
     */
    public class ShowItems extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public ShowItems(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println("------------ Show all items : --------------");
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }
        }
    }
    /**
     * Класс, редактирует заявку.
     */
    public class EditItem extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public EditItem(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println("------------ Edit item : --------------");
            String id = input.ask("Enter ID of the item :");
            if (tracker.findById(id) != null) {
                String name = input.ask("Enter the name of the item :");
                String desc = input.ask("Enter a description of the item :");
                Item item = new Item(name, desc);
                tracker.replace(id, item);
                System.out.println("Item with ID : " + id + " replaced");
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс, удаляет заявку.
     */
    public class DeleteItem extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public DeleteItem(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println("------------ Delete item : --------------");
            String id = input.ask("Enter ID of the item :");
            if (tracker.delete(id)) {
                System.out.println("Item with ID : " + id + " deleted");
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс, ищет заявку по ID.
     */
    public class FindItemById extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public FindItemById(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println("------------ Find item by Id : --------------");
            String id = input.ask("Enter ID of the item :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
        }
    }
    /**
     * Класс, ищет заявку по имени.
     */
    public class FindItemsByName extends BaseAction {
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         */
        public FindItemsByName(final int key, final String name) {
            super(key, name);
        }
        @Override
        public final void execute(final Input input, final ITracker tracker) {
            System.out.println(
                    "------------ Find item by Name : --------------");
            String name = input.ask("Enter Name of the item :");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
    }
    /**
     * Класс, для завершения работы с программой.
     */
    public class ExitProgram extends BaseAction {
        /**
         * @param ui хранит ссылку на объект StartUI.
         */
        private final StartUI ui;
        /**
         * Конструктор.
         * @param key пункт меню
         * @param name имя
         * @param ui объект StartUI для выхода
         */
        public ExitProgram(final int key, final String name, final StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        @Override
        public final void execute(final Input input, ITracker tracker) {
            this.ui.stop();
        }
    }
    /**
     * Метод в зависимости от ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public final void select(final int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public final void show(Consumer<String> media) {
        for (UserAction action : this.actions) {
            if (action != null) {
                media.accept(action.info());
            }
        }
    }
}

