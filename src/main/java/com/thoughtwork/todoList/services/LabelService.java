package com.thoughtwork.todoList.services;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.exceptions.LabelNotFoundException;
import com.thoughtwork.todoList.repositories.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {
    private final String LABEL_NOT_FOUND ="LABEL_NOT_FOUND";
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
        Optional<Label> labelToDelete=labelRepository.findById(labelID);
        if (labelToDelete.isPresent()){
            labelRepository.deleteById(labelID);
        }
        else{
            throw new LabelNotFoundException(LABEL_NOT_FOUND);
        }
    }
}
