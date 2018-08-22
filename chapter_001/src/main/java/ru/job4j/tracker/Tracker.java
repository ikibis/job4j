package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }
    /**
     * должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по
     * id.  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с
     * помощью System.arrayCopy();
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (id.equals(items[index].getId())) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * возвращает копию массива this.items без null элементов;
     **/
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName
     * класса Item) с аргументом метода String key. Элементы, у которых совпадает name, копирует в
     * результирующий массив и возвращает его;
     **/
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }
    /**
     * проверяет в цикле все элементы массива this.items, сравнивая id с аргументом String id и
     * возвращает найденный Item. Если Item не найден - возвращает null.
     **/
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

