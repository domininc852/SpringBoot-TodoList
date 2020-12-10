package com.thoughtwork.todoList.ServiceTest;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.repositories.TodoListRepository;
import com.thoughtwork.todoList.services.TodoListService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodoListServiceTest {
    @Test
    public void should_return_all_todo_items_when_get_all_given_todo_list() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        List<Label> labels = Arrays.asList(new Label("1", "shopping", "white"));
        List<TodoItem> todos = Arrays.asList(new TodoItem("1", "abc", false, labels));
        Mockito.when(todoListRepository.findAll()).thenReturn(todos);
        //when
        List<TodoItem> actualTodos = todoListService.getAllTodoItems();
        //then
        assertEquals(todos, actualTodos);
    }
}
