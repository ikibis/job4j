package ru.job4j.parser;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void parseIt() throws IOException, ParseException {
        for (int i = 0; i < 10; i++) {
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
                    String vacancyUrl = links2.attr("abs:href");
                    Document doc1 = Jsoup.connect(vacancyUrl).get();
                    Element desc = doc1.select(".msgBody").get(1);
                    String vacancyDescription = desc.text();
                    if (vacancyDescription.length() > 1999) {
                        vacancyDescription = vacancyDescription.substring(0, 1999);
                    }
                    Element dateElement = doc1.select(".msgFooter").first();
                    String vacancyDate = dateElement.text();
                    vacancyDate = vacancyDate.substring(0, vacancyDate.indexOf(','));
                    System.out.println(vacancyDate);
              /*      if (date.equals("вчера")) {
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy");
                        calendar.setTime(sdf.parse(new Date().toString()));
                        calendar.add(Calendar.DATE, -1);
                        date = sdf.format(calendar.getTime());
                    }
                    */
                    if (vacancyDate.equals("сегодня")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy");
                        Date currentDate = new Date();
                        vacancyDate = sdf.format(currentDate);
                    }
                    this.storage.add(new Vacancy(vacancyName, vacancyUrl, vacancyDescription, vacancyDate));
                }
            }
        }
    }
}