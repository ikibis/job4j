package ru.job4j.examples;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Storage extends CrudRepository<User, Integer> {
    //User add(User user);

    List<User> findAll();

    User findById(int id);
}
