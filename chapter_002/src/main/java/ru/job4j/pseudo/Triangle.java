package ru.job4j.pseudo;

import java.util.*;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("\\r\\n");
        pic.append("  + +  ");
        pic.append("\\r\\n");
        pic.append(" +   + ");
        pic.append("\\r\\n");
        pic.append("+++++++");
        return pic.toString();
    }
}
