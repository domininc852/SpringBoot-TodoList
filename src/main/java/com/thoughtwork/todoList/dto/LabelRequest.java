package com.thoughtwork.todoList.dto;

public class LabelRequest {
    private String description;
    private String color;

    public LabelRequest(String description, String color) {
        this.description = description;
        this.color = color;
    }

    public LabelRequest() {
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
