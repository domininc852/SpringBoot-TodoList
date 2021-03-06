package com.thoughtwork.todoList.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class TodoItem {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String text;
    private boolean done;
    private List<String> labels = new ArrayList<>();

    public TodoItem(String id, String text, boolean done, List<String> labels) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.labels = labels;
    }

    public TodoItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
