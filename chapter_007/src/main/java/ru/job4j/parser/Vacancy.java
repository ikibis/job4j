package ru.job4j.parser;

public class Vacancy {
    private String name;
    private String url;
    private String description;

    public Vacancy(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
