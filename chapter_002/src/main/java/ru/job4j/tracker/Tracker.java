package ru.job4j.tracker;

import java.util.*;
import java.util.function.Predicate;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    /**
     * Должен заменить ячейку в массиве this.items
     * Для этого необходимо найти ячейку в массиве по id
     */
    public void replace(String id, Item item) {
        Iterator<Item> iterator = items.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            Predicate<String> predicate = p -> p.equals(id);
            if (predicate.test(currentItem.getId())) {
                this.items.set(count, item);
                break;
            }
            count++;
        }
    }
    /**
     * должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по
     * id.  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с
     * помощью System.arrayCopy();
     */
    public boolean delete(String id) {
        boolean result = false;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            Predicate<String> predicate = p -> p.equals(id);
            if (predicate.test(currentItem.getId())) {
                iterator.remove();
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * возвращает копию массива this.items без null элементов;
     **/
    public List<Item> findAll() {
        return items;
    }
    /**
     * проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName
     * класса Item) с аргументом метода String key. Элементы, у которых совпадает name, копирует в
     * результирующий массив и возвращает его;
     **/


    public List<Item> findByName(String key) {
        List<Item> itemsCopyByName = new ArrayList<>();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            Predicate<String> predicate = p -> p.equals(key);
            if (predicate.test(currentItem.getName())) {
                itemsCopyByName.add(currentItem);
            }
        }
        return itemsCopyByName;
    }
    /**
     * проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id и
     * возвращает найденный Item. Если Item не найден - возвращает null.
     **/
    public Item findById(String id) {
        Item result = null;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            Predicate<String> predicate = p -> p.equals(id);
            if (predicate.test(currentItem.getId())) {
                result = currentItem;
                break;
            }
        }
        return result;
    }
}

