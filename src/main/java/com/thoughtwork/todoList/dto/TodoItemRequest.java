package com.thoughtwork.todoList.dto;

import java.util.List;

public class TodoItemRequest {
    private String text;
    private boolean done;
    private List<String> labels;

    public TodoItemRequest(String text, boolean done, List<String> labels) {
        this.text = text;
        this.done = done;
        this.labels = labels;
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

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
