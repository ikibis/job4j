package ru.job4j.students;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, Student> studentsToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getName, student -> student));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(new StudentComparator())
                .flatMap(Stream::ofNullable)
                .distinct()
                .dropWhile(student -> student.getScore() < bound)
                .collect(Collectors.toList());
    }
}
