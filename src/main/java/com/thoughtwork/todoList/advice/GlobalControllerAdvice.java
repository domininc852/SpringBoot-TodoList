package com.thoughtwork.todoList.advice;

import com.thoughtwork.todoList.exceptions.LabelNotFoundException;
import com.thoughtwork.todoList.exceptions.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(IllegalArgumentException exception){
        return new ErrorResponse(exception.getMessage(),HttpStatus.BAD_REQUEST.name());
    }

    @ExceptionHandler(LabelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleLabelNotFound(LabelNotFoundException exception){
        return new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.name());
    }
    @ExceptionHandler(TodoItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTodoItemNotFound(TodoItemNotFoundException exception){
        return new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.name());
    }
}
