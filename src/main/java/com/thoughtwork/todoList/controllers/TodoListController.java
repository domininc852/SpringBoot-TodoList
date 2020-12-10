package com.thoughtwork.todoList.controllers;

import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoListController {
    @Autowired
    private TodoListService todoListService;
    @GetMapping
    public List<TodoItem> getAllTodoItems(){
        return todoListService.getAllTodoItems();
    }
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem){
        todoListService.addTodoItem(todoItem);
    }
}
