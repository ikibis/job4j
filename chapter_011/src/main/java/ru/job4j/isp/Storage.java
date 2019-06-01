package ru.job4j.isp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Storage {
    private static final Storage STORAGE = new Storage();

    public static Storage getInstance() {
        return STORAGE;
    }

    private Map<String, Item> items = new TreeMap<>();

    public void addItem(String name, String parentNumber) {
        if (parentNumber.equals("0")) {
            String number = String.valueOf(items.size() + 1);
            Item item = new Item(number, name);
            items.put(number, item);
        } else {
            Item parent = items.get(parentNumber);
            List<Item> parentChildrens = parent.getChildren();
            int num = parentChildrens.size() + 1;
            String number = parentNumber + "." + num;
            Item item = new Item(number, name);
            items.put(number, item);
            parentChildrens.add(item);
            item.setParent(parent);
        }
    }

    public void showItems() {
        if (!items.isEmpty()) {
            System.out.println();
            for (Map.Entry<String, Item> entry : items.entrySet()) {
                String result = "";
                for (int i = 1; i < entry.getKey().length(); i++) {
                    result += "-";
                }
                System.out.println(result + entry.getKey() + " " + entry.getValue().getName());
            }
            System.out.println();
        }
    }
}
