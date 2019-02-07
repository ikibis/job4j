package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


public class CronTriggerRunner {
    private static final Logger LOGGER = LogManager.getLogger(CronTriggerRunner.class.getName());

    public void task() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        JobDetail job = newJob(SimpleQuartzJob.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").
                withSchedule(cronSchedule("* * 12 * * ?"))
                .build();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static void main(String[] args) {
        try {
            new CronTriggerRunner().task();
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
