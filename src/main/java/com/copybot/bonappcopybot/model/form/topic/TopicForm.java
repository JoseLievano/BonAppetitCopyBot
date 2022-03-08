package com.copybot.bonappcopybot.model.form.topic;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class TopicForm {

    private String topic;

}
