package ru.job4j.switcher;

import org.junit.Before;
import org.junit.Test;

public class SwitcherTest {
    Message message;

    @Before
    public void beforeTest() {
        message = new Message("");
    }

    @Test
    public void when2Threads() {
        Thread switcher = new Switcher(message);
        switcher.start();
        //assertThat(switcher.getText(), is("1111111111222222222211111111112222222222111111111122222222221111111111222222222211111111112222222222"));
    }
}

