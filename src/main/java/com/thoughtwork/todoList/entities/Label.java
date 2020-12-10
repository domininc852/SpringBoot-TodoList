package com.thoughtwork.todoList.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Label {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String description;
    private String color;

    public Label(String id, String description, String color) {
        this.id = id;
        this.description = description;
        this.color = color;
    }

    public Label() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
