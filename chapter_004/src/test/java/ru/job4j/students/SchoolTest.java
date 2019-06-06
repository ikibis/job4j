package ru.job4j.students;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    List<Student> list;
    School school;
    Predicate<Student> predicate;
    Student alex;
    Student ivan;
    Student andrey;
    Student ilya;
    Student mark;

    @Before
    public void prepare() {
        list = new ArrayList<>();
        school = new School();
        alex = new Student(25);
        ivan = new Student(45);
        andrey = new Student(55);
        ilya = new Student(65);
        mark = new Student(85);

        list.add(alex);
        list.add(ivan);
        list.add(andrey);
        list.add(ilya);
        list.add(mark);
    }

    @Test
    public void whenA() {
        predicate = (s) -> s.score > 70 && s.score < 100;
        List<Student> result = school.collect(list, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(mark);
        assertThat(result, is(expected));
    }

    @Test
    public void whenB() {
        predicate = (s) -> s.score > 50 && s.score < 70;
        List<Student> result = school.collect(list, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(andrey);
        expected.add(ilya);
        assertThat(result, is(expected));
    }

    @Test
    public void whenC() {
        predicate = (s) -> s.score > 0 && s.score < 50;
        List<Student> result = school.collect(list, predicate);
        List<Student> expected = new ArrayList<>();
        expected.add(alex);
        expected.add(ivan);
        assertThat(result, is(expected));
    }
}
