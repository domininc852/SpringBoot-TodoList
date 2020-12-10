package com.thoughtwork.todoList.controllers;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labels")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping
    public List<Label> getAllLabel() {
        return labelService.getAllLabel();
    }

    @PostMapping
    public Label addLabel(@RequestBody Label label){
        return labelService.addLabel(label);
    }
    @DeleteMapping("/{labelID}")
    public void deleteLabel(@PathVariable String labelID){
        labelService.deleteLabel(labelID);
    }
    @PutMapping("/{labelID}")
    public Label updateLabel(@PathVariable String labelID, @RequestBody Label label){
        return labelService.updateLabel(labelID, label);
    }
}
