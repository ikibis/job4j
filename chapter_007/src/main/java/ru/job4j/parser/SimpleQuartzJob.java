package ru.job4j.parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleQuartzJob implements Job {
    private static final Logger LOGGER = LogManager.getLogger(SimpleQuartzJob.class.getName());
    Program program;
    String url = "https://www.sql.ru/forum/job-offers/";
    String toSearch = "java ";
    String notSearch = "script";
    public SimpleQuartzJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        program = new Program(url, toSearch, notSearch);
        try {
            program.start();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}

