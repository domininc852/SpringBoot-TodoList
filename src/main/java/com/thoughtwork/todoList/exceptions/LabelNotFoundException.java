package com.thoughtwork.todoList.exceptions;

public class LabelNotFoundException extends RuntimeException {
    public LabelNotFoundException(String message) {
        super(message);
    }
}
