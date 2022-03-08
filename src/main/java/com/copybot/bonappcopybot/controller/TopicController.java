package com.copybot.bonappcopybot.controller;

import com.copybot.bonappcopybot.model.dto.topic.TopicDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicMiniDTO;
import com.copybot.bonappcopybot.model.form.topic.TopicForm;
import com.copybot.bonappcopybot.service.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topic")
public class TopicController extends DefaultController<TopicDTO, TopicMiniDTO, TopicForm, Long>{

    protected TopicController(DefaultService<TopicDTO, TopicMiniDTO, TopicForm, Long> service){
        super(service);
    }

}
