package ru.job4j.parser;

import org.junit.Before;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

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
    public void startProgram() throws URISyntaxException, IOException, SchedulerException, ParseException {
        program.start();
    }
}
