package ru.job4j.parser;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2; i++) {
            String page;
            if (i != 0) {
                page = String.valueOf(i);
            } else {
                page = "";
            }
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + page).get();
            Elements links = doc.getElementsByTag("a");
            String search = "java";
            String notSearch = "script";
            for (Element link : links) {
                boolean contains = link.text().toLowerCase().indexOf(search.toLowerCase()) != -1;
                boolean notContains = link.text().toLowerCase().indexOf(notSearch.toLowerCase()) == -1;
                if (contains && notContains) {
                    Element links2 = link.select("a").first();
                    System.out.println(link);
                    System.out.println(links2.attr("Description"));
                }
            }
        }
    }
}


