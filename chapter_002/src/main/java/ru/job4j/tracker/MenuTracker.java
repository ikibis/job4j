package ru.job4j.tracker;

import java.util.*;


public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    private class AddItem implements UserAction {
        public AddItem(int i, String add_program) {

        }

        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter Name of the task :");
            String desc = input.ask("Please, enter Description of the task :");
            tracker.add(new Item(name, desc));
        }
        public String info(){
            return String.format("%s. %s", this.key(), "Add the new Item");
        }
    }
    private class ShowItems implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s@", item.getId(), item.getName()));
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
    private class EditItem implements UserAction {
        public int key() {
            return 2;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter Item ID :");
            String name = input.ask("Please, enter Name of the Item :");
            String desc = input.ask("Please, enter Description of the Item :");
            tracker.replace(id, new Item(name, desc));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }
    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter Item ID :");
            tracker.delete(id);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    private class FindItemById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter Item ID :");
            tracker.findById(id);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }
    private class FindItemsByName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter Item Name :");
            tracker.findByName(name);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
