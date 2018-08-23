package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для показа всех заявок
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа для редактирования заявки
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления заявки
     */
    private static final String DELETE = "3";
    /**
     * Константа для поиска заявки по ID
     */
    private static final String FIND_ID = "4";
    /**
     * Константа для поиска заявок по имени
     */
    private static final String FIND_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter a menu item : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findIdItem();
            } else if (FIND_NAME.equals(answer)) {
                this.findNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Adding a new item --------------");
        String name = this.input.ask("Enter the name of the item :");
        String desc = this.input.ask("Enter a description of the item :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item with Id : " + item.getId() + "-----------");
    }
    private void showItems() {
        System.out.println("------------ Show all items : --------------");
        for (Item item : this.tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
    private void editItem() {
        System.out.println("------------ Edit item : --------------");
        String id = this.input.ask("Enter ID of the item :");
        if (this.tracker.findById(id) != null) {
            String name = this.input.ask("Enter the name of the item :");
            String desc = this.input.ask("Enter a description of the item :");
            Item item = new Item(name, desc);
            this.tracker.replace(id, item);
            System.out.println("Item with ID : " + id + " replaced");
        } else {
            System.out.println("Item not found");
        }

    }
    private void deleteItem() {
        System.out.println("------------ Delete item : --------------");
        String id = this.input.ask("Enter ID of the item :");
        if (this.tracker.delete(id)) {
            System.out.println("Item with ID : " + id + " deleted");
        } else {
            System.out.println("Item not found");
        }
    }
    private void findIdItem() {
        System.out.println("------------ Find item by Id : --------------");
        String id = this.input.ask("Enter ID of the item :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found");
        }
    }
    private void findNameItem() {
        System.out.println("------------ Find item by Name : --------------");
        String name = this.input.ask("Enter Name of the item :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("---------------------");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("---------------------");
    }
    /**
     * Запускт программы.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
