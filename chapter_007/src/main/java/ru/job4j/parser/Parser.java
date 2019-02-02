package ru.job4j.parser;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;

public class Parser {

    private Storage storage;

    private String url;
    private String toSearch;
    private String notSearch;

    public Parser(String url, String toSearch, String notSearch, Storage storage) {
        this.url = url;
        this.toSearch = toSearch;
        this.notSearch = notSearch;
        this.storage = storage;
    }

    public void parse() throws IOException {
        for (int i = 0; i < 3; i++) {
            String page;
            if (i != 0) {
                page = String.valueOf(i);
            } else {
                page = "";
            }
            Document doc = Jsoup.connect(this.url + page).get();
            Elements links = doc.getElementsByTag("a");
            for (Element link : links) {
                boolean contains = link.text().toLowerCase().contains(this.toSearch.toLowerCase());
                boolean notContains = !link.text().toLowerCase().contains(this.notSearch.toLowerCase());
                if (contains && notContains) {
                    Element links2 = link.select("a").first();
                    String vacancyName = links2.text();
                    String vacancyUrl = links2.attr("href");
                    String vacancyDescription = " ";
                    this.storage.add(new Vacancy(vacancyName, vacancyUrl, vacancyDescription));
                }
            }
        }
    }
}






