package ru.job4j.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;


public class ByteStreamCheck {
    private static final Logger LOGGER = LogManager.getLogger(ByteStreamCheck.class.getName());

    boolean isNumber(InputStream in) {
        boolean result = false;
        try (InputStream in2 = in) {
            int number = in.read();
            if (number != 0 && number % 2 == 0) {
                result = true;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
}

