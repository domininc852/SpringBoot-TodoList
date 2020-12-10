package com.thoughtwork.todoList.services;

import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.exceptions.TodoItemNotFoundException;
import com.thoughtwork.todoList.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {
    private final String TODO_ITEM_NOT_FOUND = "Todo Item not found";
    private TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        return todoListRepository.findAll();
    }

    public TodoItem addTodoItem(TodoItem todoItem) {
        return todoListRepository.save(todoItem);
    }

    public void deleteTodoItem(String todoID) {
        Optional<TodoItem> todoItemToDelete = todoListRepository.findById(todoID);
        if (todoItemToDelete.isPresent()) {
            todoListRepository.deleteById(todoID);
        } else {
            throw new TodoItemNotFoundException(TODO_ITEM_NOT_FOUND);
        }


    }

    public TodoItem updateTodoItem(String todoID, TodoItem todoItem) {
        Optional<TodoItem> todoItemToUpdate = todoListRepository.findById(todoID);
        if (todoItemToUpdate.isPresent()) {
            return todoListRepository.save(todoItem);
        }
        throw new TodoItemNotFoundException(TODO_ITEM_NOT_FOUND);

    }
}
