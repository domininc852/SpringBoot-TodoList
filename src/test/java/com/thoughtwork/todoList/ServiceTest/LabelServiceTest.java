package com.thoughtwork.todoList.ServiceTest;

import com.thoughtwork.todoList.entities.Label;
import com.thoughtwork.todoList.repositories.LabelRepository;
import com.thoughtwork.todoList.services.LabelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
