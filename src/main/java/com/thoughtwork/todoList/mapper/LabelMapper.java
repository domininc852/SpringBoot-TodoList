package com.thoughtwork.todoList.mapper;

import com.thoughtwork.todoList.dto.LabelRequest;
import com.thoughtwork.todoList.dto.LabelResponse;
import com.thoughtwork.todoList.entities.Label;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LabelMapper {
    public Label toEntity(LabelRequest labelRequest) {
        Label label = new Label();
        BeanUtils.copyProperties(labelRequest, label);
        return label;
    }

    public LabelResponse toResponse(Label label) {
        LabelResponse labelResponse = new LabelResponse();
        BeanUtils.copyProperties(label, labelResponse);
        return labelResponse;
    }
}
