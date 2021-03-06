package ru.job4j.examples;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserStorageTest {

    @Test
    public void whenLoadContextShouldGetMemoryStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        DbStorage memory = context.getBean(DbStorage.class);
        memory.add(new User("Elena"));
        assertNotNull(memory);
    }

    @Test
    public void whenLoadContextShouldGetUserStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        DbStorage memory = context.getBean(DbStorage.class);
        memory.add(new User("Ivan"));
        assertNotNull(memory);
    }

    @Test
    public void whenAddUserToDbShouldSafeIt() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        DbStorage memory = context.getBean(DbStorage.class);
        User user = memory.add(new User("Eva"));
        assertThat(memory.findById(user.getId()).getName(), is(user.getName()));
    }
}
