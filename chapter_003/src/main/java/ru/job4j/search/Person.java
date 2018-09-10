package ru.job4j.search;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    public String toString(Person person) {
        return String.format("Name: %s Surname: %s Phone: %s Address: %s",
                person.getName(),
                person.getSurname(),
                person.getPhone(),
                person.getAddress());
    }
}

