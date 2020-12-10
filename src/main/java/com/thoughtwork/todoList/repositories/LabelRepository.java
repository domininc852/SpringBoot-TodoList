package com.thoughtwork.todoList.repositories;

import com.thoughtwork.todoList.entities.Label;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LabelRepository extends MongoRepository<Label, String> {
}
