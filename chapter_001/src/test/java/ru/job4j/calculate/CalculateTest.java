package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Ilya Kibis(mailto:ilya.kibis@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
    		String input = "Ilya Kibis";
    		String expect = "Echo, echo, echo : Ilya Kibis";
    		Calculate calc = new Calculate();
    		String result = calc.echo(input);
    		assertThat(result, is(expect));
	} 
}