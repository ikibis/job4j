package ru.job4j.tdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestTemplate {
    @Test
    public void whenTakeTextWithOnesDataShouldReplaceParamsToData() {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Ilya");
        String checked = "Hello, Ilya.";

        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test
    public void whenTakeTextWithMoreDataShouldReplaceParamsToData() {
        Template template = new SimpleGenerator();
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Ilya");
        data.put("subject", "you");
        String checked = "I am a Ilya, Who are you?";

        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test
    public void whenTakeTextWithMoreSameDataShouldReplaceParamsToData() {
        Template template = new SimpleGenerator();
        String text = "Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> data = new HashMap<>();
        data.put("sos", "Aaaa");
        String checked = "Help, Aaaa, Aaaa, Aaaa";
        String result = template.generate(text, data);
        assertThat(result, is(checked));
    }

    @Test
    public void whenNotEnoughKeys() {
        String result = "";
        Template template = new SimpleGenerator();
        String text = "Help, ${sos}, ${rescue}";
        Map<String, String> data = new HashMap<>();
        data.put("sos", "Aaaa");
        try {
            template.generate(text, data);
        } catch (Exception e) {
            result = e.getMessage();
        }
        assertThat(result, is("Not enough keys in the data Map"));
    }

    @Test
    public void whenTooManyKeys() {
        String result = "";
        Template template = new SimpleGenerator();
        String text = "Help, ${sos}, ${rescue}";
        Map<String, String> data = new HashMap<>();
        data.put("sos", "Aaaa");
        data.put("rescue", "save");
        data.put("excess", "excess");
        data.put("excess2", "excess2");
        try {
            template.generate(text, data);
        } catch (Exception e) {
            result = e.getMessage();
        }
        assertThat(result, is("Too many keys in the data Map"));
    }
}
