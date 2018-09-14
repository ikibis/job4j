package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 * @autor Ilya Kibis
 */

/**
 * Класс, описывающий заявку.
 */
public class Item {
    /**
     * ID заявки.
     */
    private String id;
    /**
     * Имя заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String description;
    /**
     * Конструтор инициализирующий поля.
     * @param name имя заявки.
     * @param description Описание заявки.
     */
    public Item(final String name, final String description) {
        this.name = name;
        this.description = description;
    }
    /**
     * Метод возвращающий ID заявки.
     * @return id ID заявки.
     */
    public final String getId() {
        return this.id;
    }
    /**
     * Метод возвращающий имя заявки.
     * @return name имя заявки.
     */
    public final String getName() {
        return this.name;
    }
    /**
     * Метод возвращающий описание заявки.
     * @return description описание заявки.
     */
    public final String getDescription() {
        return this.description;
    }
    /**
     * Метод задающий имя заявки.
     * @param  name имя заявки.
     */
    public final void setName(final String name) {
        this.name = name;
    }
    /**
     * Метод задающий описание заявки.
     * @param description описание заявки.
     */
    public final void setDescription(final String description) {
        this.description = description;
    }
    /**
     * Метод задающий ID заявки.
     * @param id ID заявки.
     */
    public final void setId(final String id) {
        this.id = id;
    }
    /**
     * Метод задающий строковое представление заявки.
     * @return cтроковое представление заявки.
     */
    public final String toString() {
        return "Id : " + this.id + " Item : " + this.name
                + " Description : " + this.description;
    }
}

