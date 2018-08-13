ppackage ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubtractFourMinusOneThenThree() {
        Calculator calc = new Calculator();
        calc.subtract(4D, 1D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenDivSixOnThreeThenTwo() {
        Calculator calc = new Calculator();
        calc.add(6D, 3D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultipleThreeOnFourThenTwelve() {
        Calculator calc = new Calculator();
        calc.add(3D, 4D);
        double result = calc.getResult();
        double expected = 12D;
        assertThat(result, is(expected));
    }
}