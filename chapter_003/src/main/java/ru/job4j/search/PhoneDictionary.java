package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        Person searchedPerson;
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            searchedPerson = iterator.next();
            if (
                               searchedPerson.getName().contains(key)
                            || searchedPerson.getSurname().contains(key)
                            || searchedPerson.getPhone().contains(key)
                            || searchedPerson.getAddress().contains(key)
            ) {
                result.add(searchedPerson);
            }
        }
        return result;
    }
}

