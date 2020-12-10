package com.thoughtwork.todoList.repositories;

import com.thoughtwork.todoList.entities.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends MongoRepository<TodoItem, String> {
}
