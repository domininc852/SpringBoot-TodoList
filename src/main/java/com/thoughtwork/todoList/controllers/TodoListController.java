package com.thoughtwork.todoList.controllers;

import com.thoughtwork.todoList.dto.LabelResponse;
import com.thoughtwork.todoList.dto.TodoItemRequest;
import com.thoughtwork.todoList.dto.TodoItemResponse;
import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.mapper.LabelMapper;
import com.thoughtwork.todoList.mapper.TodoItemMapper;
import com.thoughtwork.todoList.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @Autowired
    private TodoItemMapper todoItemMapper;

    @Autowired
    private LabelMapper labelMapper;

    private List<LabelResponse> getLabels(String todoID){
        return todoListService.getLabelsByTodoItemID(todoID).stream().map(labelMapper::toResponse).collect(Collectors.toList());
    }
    @GetMapping
    public List<TodoItemResponse> getAllTodoItems() {
        return todoListService.getAllTodoItems().stream().map(todoItem ->
            todoItemMapper.toResponse(todoItem,getLabels(todoItem.getId()))
        ).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoItemResponse addTodoItem(@RequestBody TodoItemRequest todoItemRequest) {
        TodoItem todoItem = todoListService.addTodoItem(todoItemMapper.toEntity(todoItemRequest));
        return todoItemMapper.toResponse(todoItem,getLabels(todoItem.getId()));

    }

    @DeleteMapping("/{todoID}")
    public void deleteTodo(@PathVariable String todoID) {
        todoListService.deleteTodoItem(todoID);
    }

    @PutMapping("/{todoID}")
    public TodoItemResponse updateTodo(@PathVariable String todoID, @RequestBody TodoItemRequest todoItemRequest) {
        TodoItem todoItem = todoListService.updateTodoItem(todoID, todoItemMapper.toEntity(todoItemRequest));
        return todoItemMapper.toResponse(todoItem,getLabels(todoItem.getId()));
    }
}
