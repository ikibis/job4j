package ru.job4j.srp.io;

public class Output {

    Object value;
    String message;

    public Output(Object value, String message) {
        this.value = value;
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
