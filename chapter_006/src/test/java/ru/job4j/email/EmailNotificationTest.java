package ru.job4j.email;

import org.junit.Before;
import org.junit.Test;

public class EmailNotificationTest {
    UserStorage storage;
    EmailNotification consumer;

    @Before
    public void beforeTest() {
        storage = new UserStorage();
        consumer = new EmailNotification();
    }

    @Test
    public void whenTest() {
        for (int i = 0; i < 100; i++) {
            String name = i + " name";
            String email = i + " email";
            storage.add(new User(name, email));
        }
        for (int i = 0; i < 100; i++) {
            consumer.emailTo(storage.poll());
        }
    }
}
