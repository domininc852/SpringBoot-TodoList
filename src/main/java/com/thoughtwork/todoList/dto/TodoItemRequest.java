package com.thoughtwork.todoList.dto;

import com.thoughtwork.todoList.entities.Label;

import java.util.List;

public class TodoItemRequest {
    private String text;
    private boolean done;
    private List<String> labelIDs;

    public TodoItemRequest(String text, boolean done, List<String> labelIDs) {
        this.text = text;
        this.done = done;
        this.labelIDs = labelIDs;
    }

    public TodoItemRequest() {
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

    public List<String> getLabelIDs() {
        return labelIDs;
    }

    public void setLabelIDs(List<String> labelIDs) {
        this.labelIDs = labelIDs;
    }
}
