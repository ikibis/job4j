package ru.job4j.pseudo;

import java.util.*;

public class Triangle implements Shape {
    @Override
    public String draw() {
        String ls = System.lineSeparator();
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ").append(ls);
        pic.append("  + +  ").append(ls);
        pic.append(" +   + ").append(ls);
        pic.append("+++++++");
        return pic.toString();
    }
}
