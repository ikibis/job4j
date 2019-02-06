package ru.job4j.parser;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.text.ParseException;

public class ParserTest {
    Program program;
    String url = "https://www.sql.ru/forum/job-offers/";
    String toSearch = "java ";
    String notSearch = "script";

    @Before
    public void createConnection() {
        program = new Program(url, toSearch, notSearch);
    }

    @Test
    public void startProgram() throws IOException, ParseException {
        program.start();
    }
}
