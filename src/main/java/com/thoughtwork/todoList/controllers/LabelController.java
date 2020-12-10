package com.thoughtwork.todoList.controllers;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping
    public List<Label> getAllLabel() {
        return labelService.getAllLabel();
    }
}
