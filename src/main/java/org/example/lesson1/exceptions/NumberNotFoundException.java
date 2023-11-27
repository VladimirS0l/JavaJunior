package org.example.lesson1.exceptions;

public class NumberNotFoundException extends RuntimeException {
    public NumberNotFoundException(String msg) {
        super(msg);
    }
}
