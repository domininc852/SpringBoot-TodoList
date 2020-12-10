package com.thoughtwork.todoList.dto;

public class LabelResponse {
    private String id;
    private String description;
    private String color;

    public LabelResponse(String id, String description, String color) {
        this.id = id;
        this.description = description;
        this.color = color;
    }

    public LabelResponse() {
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
