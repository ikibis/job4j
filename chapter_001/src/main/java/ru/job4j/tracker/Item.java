package ru.job4j.tracker;


/**
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    public String name;
    public String description;
    public long created;
    public String[] comments;

    public Item() { }
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
    public long getCreated() {
        return this.created;
    }
    public void setId(String id) {
        this.id = id;
    }
}

