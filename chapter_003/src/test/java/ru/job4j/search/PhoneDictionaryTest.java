package ru.job4j.search;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Petr1", "Arsentev1", "5348721", "Bryansk1")
        );
        List<Person> persons = phones.find("r1");
        for (Person person : persons) {
            System.out.println(person.toString(person));
            assertThat(person.getSurname(), is("Arsentev1"));
        }
    }
}

