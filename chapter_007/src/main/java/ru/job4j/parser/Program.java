package ru.job4j.parser;

import java.io.IOException;
import java.text.ParseException;

public class Program {

    private Parser parser;
    private Storage storage;
    private ParserSQL sql;

    public Program(String url, String toSearch, String notSearch) {
        this.storage = new Storage();
        this.parser = new Parser(url, toSearch, notSearch, this.storage);
        this.sql = new ParserSQL();
        sql.init();
    }

    public void start() throws IOException, ParseException {
        sql.createNewDB();
        this.parser.parseIt();
        while (!this.storage.empty()) {
            sql.add(this.storage.poll());
        }
//        sql.deleteDB();
    }
}
