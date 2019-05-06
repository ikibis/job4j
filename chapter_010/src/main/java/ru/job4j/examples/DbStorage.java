package ru.job4j.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbStorage {

    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring-context.xml");
    private static final Storage STORAGE = CONTEXT.getBean(Storage.class);

    //private static final StorageWrapper WRAPPER = StorageWrapper.getINSTANCE();

    @Autowired
    public DbStorage() {
    }

    public User add(User user) {
        return STORAGE.save(user);
    }

    public List<User> findAll() {
        return STORAGE.findAll();
    }

    public User findById(int id) {
        return STORAGE.findById(id);
    }

}
