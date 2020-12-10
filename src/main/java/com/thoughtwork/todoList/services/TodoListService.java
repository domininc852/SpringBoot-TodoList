package com.thoughtwork.todoList.services;

import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public List<TodoItem> getAllTodoItems(){
        return todoListRepository.findAll();
    }

    public TodoItem addTodoItem(TodoItem todoItem) {
        return null;
    }
}
