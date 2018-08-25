package ru.job4j.pseudo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        String ls = System.lineSeparator();
        pic.append("++++").append(ls);
        pic.append("+  +").append(ls);
        pic.append("+  +").append(ls);
        pic.append("++++");
        return pic.toString();
    }
}
