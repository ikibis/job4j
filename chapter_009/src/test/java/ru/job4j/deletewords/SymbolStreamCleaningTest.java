package ru.job4j.deletewords;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class SymbolStreamCleaningTest {

    @Test
    public void whenInputStream() throws IOException {
        SymbolStreamCleaning ssc = new SymbolStreamCleaning();
        String abuse = "abuse";
        String str = "new abuse reader writer";
        ssc.dropAbuses(new ByteArrayInputStream(str.getBytes()), abuse);
    }
}
