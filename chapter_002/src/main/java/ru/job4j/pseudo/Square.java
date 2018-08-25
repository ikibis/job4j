package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("\\r\\n");
        pic.append("+  +");
        pic.append("\\r\\n");
        pic.append("+  +");
        pic.append("\\r\\n");
        pic.append("++++");
        return pic.toString();
    }
}
