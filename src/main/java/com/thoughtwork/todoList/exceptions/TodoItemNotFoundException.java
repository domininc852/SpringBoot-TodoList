package com.thoughtwork.todoList.exceptions;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(String message) {
        super(message);
    }
}
