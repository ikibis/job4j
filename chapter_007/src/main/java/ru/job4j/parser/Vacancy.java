package ru.job4j.parser;

public class Vacancy {
    private String name;
    private String url;
    private String description;
    private String date;

    public Vacancy(String name, String url, String description, String date) {
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

    public String getDate() {
        return date;
    }
}
