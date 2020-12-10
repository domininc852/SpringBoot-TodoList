package com.thoughtwork.todoList.ServiceTest;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.exceptions.LabelNotFoundException;
import com.thoughtwork.todoList.repositories.LabelRepository;
import com.thoughtwork.todoList.services.LabelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public class LabelServiceTest {
    @Test
    public void should_return_all_labels_when_get_all_label_given_label_list() {
        //given
        LabelRepository labelRepository = Mockito.mock(LabelRepository.class);
        LabelService labelService = new LabelService(labelRepository);
        List<Label> labels = Collections.singletonList(new Label("1", "shopping", "white"));
        Mockito.when(labelRepository.findAll()).thenReturn(labels);
        //when
        List<Label> actualLabels = labelService.getAllLabel();
        //then
        assertEquals(labels, actualLabels);
    }
    @Test
    public void should_return_created_label_when_get_add_label_given_a_label() {
        //given
        LabelRepository labelRepository = Mockito.mock(LabelRepository.class);
        LabelService labelService = new LabelService(labelRepository);
        Label label = new Label("1", "shopping", "white");
        Mockito.when(labelRepository.save(label)).thenReturn(label);
        //when
        Label actualLabel = labelService.addLabel(label);
        //then
        assertEquals(label, actualLabel);
    }

    @Test
    public void should_delete_todo_item_when_delete_label_given_valid_label_ID() {
        //given
        LabelRepository labelRepository = Mockito.mock(LabelRepository.class);
        LabelService labelService = new LabelService(labelRepository);
        Label label = new Label("1", "shopping", "white");
        Mockito.when(labelRepository.findById(any())).thenReturn(Optional.of(label));

        //when
        labelService.deleteLabel("1");
        //then
        Mockito.verify(labelRepository, times(1)).deleteById("1");
    }

    @Test
    public void should_return_label_not_found_exception_when_delete_label_given_invalid_label_ID() {
        //given
        LabelRepository labelRepository = Mockito.mock(LabelRepository.class);
        LabelService labelService = new LabelService(labelRepository);
        Mockito.when(labelRepository.findById(any())).thenReturn(Optional.empty());

        //when
        //then
        assertThrows(LabelNotFoundException.class, () -> labelService.deleteLabel("1"));

    }

}
