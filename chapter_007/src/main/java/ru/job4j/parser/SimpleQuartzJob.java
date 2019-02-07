package ru.job4j.parser;

import java.io.IOException;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SimpleQuartzJob implements Job {
    private static final Logger LOGGER = LogManager.getLogger(SimpleQuartzJob.class.getName());
    Program program;
    String url = "https://www.sql.ru/forum/job-offers/";
    String toSearch = "java ";
    String notSearch = "script";

    public void execute(JobExecutionContext context) {
        program = new Program(url, toSearch, notSearch);
        try {
            program.start();
        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}

