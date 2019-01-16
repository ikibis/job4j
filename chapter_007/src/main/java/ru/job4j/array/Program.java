package ru.job4j.array;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Program {
    private SQLConnector sql;
    private XmlUsage xml;
    private Stylizer stylizer;

    public Program() {
        Config config = new Config();
        sql = new SQLConnector(config);
        xml = new XmlUsage();
        stylizer = new Stylizer();
    }

    public void start(int elements) throws URISyntaxException {
        URL resUsers = Program.class.getResource("Users.xml");
        final File source = Paths.get(resUsers.toURI()).toFile();
        URL resTransformedUsers = Program.class.getResource("TransformedUsers.xml");
        final File dest = Paths.get(resTransformedUsers.toURI()).toFile();
        URL resStyle = Program.class.getResource("style.xml");
        final File style = Paths.get(resStyle.toURI()).toFile();

        long startTime = System.currentTimeMillis();
        sql.createNewDB();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("БД создалась за " + timeSpent + " миллисекунд");

        startTime = System.currentTimeMillis();
        XmlUsage.User toMarshall = new XmlUsage.User(sql.generate(elements));
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Сгенерирован список  за " + timeSpent + " миллисекунд");

        startTime = System.currentTimeMillis();
        sql.add(toMarshall);

        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Напонение БД за " + timeSpent + " миллисекунд");

        try {
            startTime = System.currentTimeMillis();
            File users = xml.generateFileXML(toMarshall, source);
            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("Сгенерирован XML за " + timeSpent + " миллисекунд");

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
