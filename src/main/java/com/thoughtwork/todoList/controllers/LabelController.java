package com.thoughtwork.todoList.controllers;

import com.thoughtwork.todoList.dto.LabelResponse;
import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.mapper.LabelMapper;
import com.thoughtwork.todoList.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/labels")
@CrossOrigin
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private LabelMapper labelMapper;

    @GetMapping
    public List<LabelResponse> getAllLabel() {
        return labelService.getAllLabel().stream().map(labelMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    public LabelResponse addLabel(@RequestBody Label label) {
        return labelMapper.toResponse(labelService.addLabel(label));
    }

    @DeleteMapping("/{labelID}")
    public void deleteLabel(@PathVariable String labelID) {
        labelService.deleteLabel(labelID);
    }

    @PutMapping("/{labelID}")
    public LabelResponse updateLabel(@PathVariable String labelID, @RequestBody Label label) {
        return labelMapper.toResponse(labelService.updateLabel(labelID, label));
    }
}
