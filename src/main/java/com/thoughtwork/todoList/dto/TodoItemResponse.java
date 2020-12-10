package com.thoughtwork.todoList.dto;


import java.util.List;

public class TodoItemResponse {
    private String id;
    private String text;
    private boolean done;
    private List<LabelResponse> labels;

    public TodoItemResponse(String id, String text, boolean done, List<LabelResponse> labels) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.labels = labels;
    }

    public TodoItemResponse() {
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

    public List<LabelResponse> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelResponse> labels) {
        this.labels = labels;
    }
}
