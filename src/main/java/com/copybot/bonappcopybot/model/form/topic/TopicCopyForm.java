package com.copybot.bonappcopybot.model.form.topic;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class TopicCopyForm {

    private String occasion;

    private String lang;

    private String copy;

    private Long topic;

}
