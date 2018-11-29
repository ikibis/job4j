package ru.job4j.array;

import java.io.File;

public class Program {
    private SQLConnector sql;
    private XmlUsage xml;
    private Stylizer stylizer;
    private File source;
    private File dest;
    private File style;

    public Program() {
        Config config = new Config();
        sql = new SQLConnector(config);
        xml = new XmlUsage();
        stylizer = new Stylizer();
        String fileSource = "/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/Users.xml";
        source = new File(fileSource);
        String fileDest = "/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/TransformedUsers.xml";
        dest = new File(fileDest);
        style = new File("/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/style.xml");
    }

    public void start(int elements) {

        long startTime = System.currentTimeMillis();
        sql.createNewDB();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("БД создалась за " + timeSpent  + " миллисекунд");

        startTime = System.currentTimeMillis();
        XmlUsage.User toMarshall = new XmlUsage.User(sql.generate(elements));
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Сгенерирован список  за " + timeSpent + " миллисекунд");

        startTime = System.currentTimeMillis();
        for (XmlUsage.Field field : toMarshall.getValues()) {
            sql.add(field.getValue());
        }
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Напонение БД за " + timeSpent + " миллисекунд");

        try {
            startTime = System.currentTimeMillis();
            File users = xml.generateFileXML(toMarshall, source);
            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("Сгенерирован XML за " + timeSpent  + " миллисекунд");

            startTime = System.currentTimeMillis();
            stylizer.convert(users, dest, style);
            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("XML изменен за " + timeSpent + " миллисекунд");

            startTime = System.currentTimeMillis();
            sql.deleteDB();
            sql.closeConnection();
            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("БД удалена за " + timeSpent + " миллисекунд");

        } catch (Exception e) {
            System.out.println("addvalues Exception" + e);
            e.printStackTrace();
        }
    }
    public void dropDB() {
        sql.deleteDB();
    }

    public void createDB() {
        sql.createNewDB();
    }
}