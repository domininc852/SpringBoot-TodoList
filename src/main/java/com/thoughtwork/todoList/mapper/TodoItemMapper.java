package com.thoughtwork.todoList.mapper;

import com.thoughtwork.todoList.dto.LabelResponse;
import com.thoughtwork.todoList.dto.TodoItemRequest;
import com.thoughtwork.todoList.dto.TodoItemResponse;
import com.thoughtwork.todoList.entities.TodoItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoItemMapper {
    public TodoItem toEntity(TodoItemRequest todoItemRequest) {
        TodoItem todoItem = new TodoItem();
        BeanUtils.copyProperties(todoItemRequest, todoItem);
        if (todoItemRequest.getLabelIDs() == null) {
            todoItem.setLabelIDs(new ArrayList<>());
        }
        return todoItem;
    }

    public TodoItemResponse toResponse(TodoItem todoItem, List<LabelResponse> labelResponses) {
        TodoItemResponse todoItemResponse = new TodoItemResponse();
        BeanUtils.copyProperties(todoItem, todoItemResponse);
        todoItemResponse.setLabels(labelResponses);
        return todoItemResponse;
    }
}
