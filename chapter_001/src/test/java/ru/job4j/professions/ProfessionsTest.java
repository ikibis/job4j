package ru.job4j.professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ProfessionsTest {
    @Test
    public void testDoctor() {
        boolean result = new Doctor().heal(new Pacient()) instanceof Diagnose;
        boolean correctly = true;
        assertThat(result, is(correctly));
    }
    @Test
    public void testEngineer() {
        boolean result = new Engineer().plot(new House()) instanceof Project;
        boolean correctly = true;
        assertThat(result, is(correctly));
    }
    @Test
    public void testTeacher() {
        boolean result = new Teacher().give(new Student()) instanceof Diploma;
        boolean correctly = true;
        assertThat(result, is(correctly));
    }
}
