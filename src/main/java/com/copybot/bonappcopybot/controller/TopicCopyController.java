package com.copybot.bonappcopybot.controller;

import com.copybot.bonappcopybot.model.dto.topic.TopicCopyDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicCopyMiniDTO;
import com.copybot.bonappcopybot.model.form.topic.TopicCopyForm;
import com.copybot.bonappcopybot.service.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topic-copy")
public class TopicCopyController extends DefaultController<TopicCopyDTO, TopicCopyMiniDTO, TopicCopyForm, Long>{

    protected TopicCopyController(DefaultService<TopicCopyDTO, TopicCopyMiniDTO, TopicCopyForm, Long> service){
        super(service);
    }

}
