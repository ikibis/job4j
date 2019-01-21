package ru.job4j.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ByteStreamCheckTest {
    @Test
    public void whenInputStreamNull() {
        ByteStreamCheck bsc = new ByteStreamCheck();
        boolean result = bsc.isNumber(new InputStream() {
                                          @Override
                                          public int read() throws IOException {
                                              return 0;
                                          }
                                      }
        );
        assertThat(result, is(false));
    }

    @Test
    public void whenInputStreamFour() {
        ByteStreamCheck bsc = new ByteStreamCheck();
        boolean result = bsc.isNumber(new InputStream() {
                                          @Override
                                          public int read() throws IOException {
                                              return 4;
                                          }
                                      }
        );
        assertThat(result, is(true));
    }

    @Test
    public void whenInputStreamFive() {
        ByteStreamCheck bsc = new ByteStreamCheck();
        boolean result = bsc.isNumber(new InputStream() {
                                          @Override
                                          public int read() throws IOException {
                                              return 5;
                                          }
                                      }
        );
        assertThat(result, is(false));
    }
}
