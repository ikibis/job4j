package ru.job4j.tracker;


/**
 * @version $Id$
 * @since 0.1 Ilya Kibis
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    public String[] comments;

    public Item() { }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "Id : " + this.id + " Item : " + this.name + " Description : " + this.description;
    }
}
