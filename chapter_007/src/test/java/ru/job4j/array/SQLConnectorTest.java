package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class SQLConnectorTest {
    SQLConnector sql;
    Config config;
    XmlUsage xml;
    String fileSource;
    String fileDest;
    Stylizer stylizer;
    File source;
    File dest;

    @Before
    public void createConnection() {
        config = new Config();
        sql = new SQLConnector(config);
        xml = new XmlUsage();
        stylizer = new Stylizer();
        fileSource = "/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/Users.xml";
        source = new File(fileSource);
        fileDest = "/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/TransformedUsers.xml";
        dest = new File(fileDest);
    }

    @Test
    public void createDB() {
        sql.createNewDB();
    }

    @Test
    public void addvalues() {
        XmlUsage.User toMarshall = new XmlUsage.User(sql.generate(1000));
        try {
            File users = xml.generateFileXML(toMarshall, source);
            stylizer.convert(users, dest);
        } catch (Exception e) {
            System.out.println("addvalues Exception" + e);
            e.printStackTrace();
        }
    }

    @Test
    public void dropTable() {
        sql.deleteDB();
    }

    @Test
    public void propertiesTest() {
        Config conf = new Config();
        System.out.println(conf.get("url"));
        System.out.println(conf.get("username"));
        System.out.println(conf.get("password"));
        System.out.println(conf.get("driver-class-name"));
    }
}
