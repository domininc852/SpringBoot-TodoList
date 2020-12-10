package com.thoughtwork.todoList.services;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    private LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> getAllLabel() {
        return labelRepository.findAll();
    }

    public Label addLabel(Label label) {
        return labelRepository.save(label);
    }

    public void deleteLabel(String labelID) {

    }
}
