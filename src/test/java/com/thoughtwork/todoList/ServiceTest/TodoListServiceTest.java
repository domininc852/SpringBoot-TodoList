package com.thoughtwork.todoList.ServiceTest;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.exceptions.TodoItemNotFoundException;
import com.thoughtwork.todoList.repositories.TodoListRepository;
import com.thoughtwork.todoList.services.TodoListService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;


public class TodoListServiceTest {
    @Test
    public void should_return_all_todo_items_when_get_all_given_todo_list() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        List<Label> labels = Collections.singletonList(new Label("1", "shopping", "white"));
        List<TodoItem> todos = Collections.singletonList(new TodoItem("1", "abc", false, labels));
        Mockito.when(todoListRepository.findAll()).thenReturn(todos);
        //when
        List<TodoItem> actualTodos = todoListService.getAllTodoItems();
        //then
        assertEquals(todos, actualTodos);
    }

    @Test
    public void should_return_todo_item_when_add_todo_given_a_todo_item() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        List<Label> labels = Collections.singletonList(new Label("1", "shopping", "white"));
        TodoItem todoItem = new TodoItem("1", "abc", false, labels);
        Mockito.when(todoListRepository.save(todoItem)).thenReturn(todoItem);
        //when
        TodoItem actualTodo = todoListService.addTodoItem(todoItem);
        //then
        assertEquals(todoItem, actualTodo);
    }

    @Test
    public void should_delete_todo_item_when_delete_todo_item_given_valid_todo_item_ID() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        List<Label> labels = Collections.singletonList(new Label("1", "shopping", "white"));
        TodoItem todoItem = new TodoItem("1", "abc", false, labels);
        Mockito.when(todoListRepository.findById(any())).thenReturn(Optional.of(todoItem));

        //when
        todoListService.deleteTodoItem("1");
        //then
        Mockito.verify(todoListRepository, times(1)).deleteById("1");
    }

    @Test
    public void should_throw_todo_item_not_found_error_when_delete_company_given_invalid_todo_item_ID() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        Mockito.when(todoListRepository.findById(any())).thenReturn(Optional.empty());

        //when
        //then
        assertThrows(TodoItemNotFoundException.class, () -> todoListService.deleteTodoItem("1"));
    }

    @Test
    public void should_return_updated_todo_item_when_update_todo_item_given_valid_todo_item_ID() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        List<Label> labels = Collections.singletonList(new Label("1", "shopping", "white"));
        TodoItem todoItem = new TodoItem("1", "abc", false, labels);
        Mockito.when(todoListRepository.findById(any())).thenReturn(Optional.of(todoItem));
        Mockito.when(todoListRepository.save(any())).thenReturn((todoItem));
        //when
        todoListService.updateTodoItem("1", todoItem);
        final ArgumentCaptor<TodoItem> companyArgumentCaptor = ArgumentCaptor.forClass(TodoItem.class);
        Mockito.verify(todoListRepository, times(1)).save(companyArgumentCaptor.capture());
        //then
        assertEquals(todoItem, companyArgumentCaptor.getValue());
    }

    @Test
    public void should_throw_todo_item_not_found_exception_when_update_todo_item_given_invalid_todo_item_ID() {
        //given
        TodoListRepository todoListRepository = Mockito.mock(TodoListRepository.class);
        TodoListService todoListService = new TodoListService(todoListRepository);
        Mockito.when(todoListRepository.findById(any())).thenReturn(Optional.empty());
        //when
        //then
        assertThrows(TodoItemNotFoundException.class, () -> todoListService.updateTodoItem("1", null));
    }
}
