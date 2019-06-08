package ru.job4j.students;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, Student> studentsToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(student -> student.getName(), student -> student));
    }
}
