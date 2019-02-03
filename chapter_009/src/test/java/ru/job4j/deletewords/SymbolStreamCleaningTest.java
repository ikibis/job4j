package ru.job4j.deletewords;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SymbolStreamCleaningTest {

    @Test
    public void whenInputStream() throws IOException {
        SymbolStreamCleaning ssc = new SymbolStreamCleaning();
        String[] abuse = {"abuse", "ubuse"};
        String str = "new abuse reader writer ubuse";
        ByteArrayOutputStream result = ssc.dropAbuses(new ByteArrayInputStream(str.getBytes()), abuse);
        assertThat(result.toString(), is("new  reader writer "));
    }
}
