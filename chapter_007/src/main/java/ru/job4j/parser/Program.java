package ru.job4j.parser;

import java.io.IOException;

public class Program {

    private Parser parser;
    private Storage storage;
    private ParserSQL sql;

    public Program(String url, String toSearch, String notSearch) {
        this.storage = new Storage();
        this.parser = new Parser(url, toSearch, notSearch, this.storage);
        this.sql = new ParserSQL();
    }

    public void start() throws IOException {
        sql.createNewDB();
        this.parser.parse();
        while (!this.storage.empty()) {
            sql.add(this.storage.poll());
        }
        //sql.deleteDB();
    }
}
