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
        this.actions.add(new MenuTracker.AddItem(0, "Add new Item"));
        this.actions.add(new MenuTracker.ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new MenuTracker.FindItemById(4, "Find item by Id"));
        this.actions.add(new MenuTracker.FindItemsByName(5, "Find items by name"));
        this.actions.add(new MenuTracker.ExitProgram(6, "Exit Program"));
    }

    public class AddItem implements UserAction {
        private int point;
        private String pointName;
        public AddItem(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class ShowItems implements UserAction {
        private int point;
        private String pointName;
        public ShowItems(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Show all items : --------------");
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class EditItem implements UserAction {
        private int point;
        private String pointName;
        public EditItem(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class DeleteItem implements UserAction {
        private int point;
        private String pointName;
        public DeleteItem(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item : --------------");
            String id = input.ask("Enter ID of the item :");
            if (tracker.delete(id)) {
                System.out.println("Item with ID : " + id + " deleted");
            } else {
                System.out.println("Item not found");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class FindItemById implements UserAction {
        private int point;
        private String pointName;
        public FindItemById(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by Id : --------------");
            String id = input.ask("Enter ID of the item :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class FindItemsByName implements UserAction {
        private int point;
        private String pointName;
        public FindItemsByName(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by Name : --------------");
            String name = input.ask("Enter Name of the item :");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
        }
    }
    public class ExitProgram implements UserAction {
        private int point;
        private String pointName;
        public ExitProgram(int point, String pointName) {
            this.point = point;
            this.pointName = pointName;
        }
        @Override
        public int key() {
            return point;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            input.ask("Exit?(y): ");
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), pointName);
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