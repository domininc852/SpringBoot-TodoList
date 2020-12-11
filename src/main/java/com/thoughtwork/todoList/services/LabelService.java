package com.thoughtwork.todoList.services;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.entities.TodoItem;
import com.thoughtwork.todoList.exceptions.LabelNotFoundException;
import com.thoughtwork.todoList.repositories.LabelRepository;
import com.thoughtwork.todoList.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabelService {
    private final String LABEL_NOT_FOUND = "LABEL_NOT_FOUND";
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private TodoListRepository todoListRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public LabelService() {
    }

    public List<Label> getAllLabel() {
        return labelRepository.findAll();
    }

    public Label addLabel(Label label) {
        return labelRepository.save(label);
    }

    public void deleteLabel(String labelID) {
        Optional<Label> labelToDelete = labelRepository.findById(labelID);
        if (labelToDelete.isPresent()) {
            labelRepository.deleteById(labelID);
            todoListRepository.findAll().forEach(todoItem -> {
                todoItem.setLabels(todoItem.getLabels().stream().
                        filter(label-> !labelID.equals(label)).collect(Collectors.toList()));
                todoListRepository.save(todoItem);

            });
        } else {
            throw new LabelNotFoundException(LABEL_NOT_FOUND);
        }
    }

    public Label updateLabel(String labelID, Label label) {
        Optional<Label> labelToUpdate = labelRepository.findById(labelID);
        if (labelToUpdate.isPresent()) {
            label.setId(labelToUpdate.get().getId());
            return labelRepository.save(label);
        } else {
            throw new LabelNotFoundException(LABEL_NOT_FOUND);
        }
    }
}
