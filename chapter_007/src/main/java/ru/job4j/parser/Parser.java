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
    private DateConverter dConv;

    public Parser(String url, String toSearch, String notSearch, Storage storage) {
        this.url = url;
        this.toSearch = toSearch;
        this.notSearch = notSearch;
        this.storage = storage;
        this.dConv = new DateConverter();
    }

    public void parseIt() throws IOException {
        boolean parseFlag = true;
        int count = 0;
        while (parseFlag) {
            String page;
            if (count != 0) {
                page = String.valueOf(count);
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
                    if (vacancyUrl.contains("memberinfo")) {
                        continue;
                    }
                    Document doc1 = Jsoup.connect(vacancyUrl).get();
                    Element desc = doc1.select(".msgBody").get(1);
                    String vacancyDescription = desc.text();
                    if (vacancyDescription.length() > 1999) {
                        vacancyDescription = vacancyDescription.substring(0, 1999);
                    }
                    Element dateElement = doc1.select(".msgFooter").first();
                    String vacancyDate = dateElement.text();

                    vacancyDate = dConv.dateConvert(vacancyDate);

                    if (dConv.dateCheck(vacancyDate)) {
                        this.storage.add(new Vacancy(vacancyName, vacancyUrl, vacancyDescription, vacancyDate));
                    } else {
                        parseFlag = false;
                        break;
                    }
                }
            }
            count++;
        }
    }
}
