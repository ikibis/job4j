package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class CronTriggerRunner {
    private static final Logger LOGGER = LogManager.getLogger(CronTriggerRunner.class.getName());

    public void cron() throws SchedulerException {
        // Запускаем Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Извлекаем планировщик из schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();

        // текущее время
        long ctime = System.currentTimeMillis();

        // Запускаем JobDetail с именем задания,
        // группой задания и классом выполняемого задания
        JobDetail jobDetail =
                new JobDetail("jobDetail2", "jobDetailGroup2", SimpleQuartzJob.class);
        // Запускаем CronTrigger с его именем и именем группы
        CronTrigger cronTrigger = new CronTrigger("cronTrigger", "triggerGroup2");
        try {
            // Устанавливаем CronExpression
            CronExpression cexp = new CronExpression("0 0 12 * * ?");
            // Присваиваем CronExpression CronTrigger'у
            cronTrigger.setCronExpression(cexp);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        // Планируем задание с помощью JobDetail и Trigger
        scheduler.scheduleJob(jobDetail, cronTrigger);

        // Запускаем планировщик
        scheduler.start();
    }

}
