package com.copybot.bonappcopybot.service.topic;

import com.copybot.bonappcopybot.mapper.topic.TopicMapper;
import com.copybot.bonappcopybot.model.dto.topic.TopicDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicMiniDTO;
import com.copybot.bonappcopybot.model.entity.topic.Topic;
import com.copybot.bonappcopybot.model.form.topic.TopicForm;
import com.copybot.bonappcopybot.repository.TopicRepository;
import com.copybot.bonappcopybot.service.defaultService.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImplements extends DefaultServiceImpl<TopicDTO, TopicMiniDTO, TopicForm, Topic, Long> {

    public TopicServiceImplements(TopicRepository repository, TopicMapper mapper){
        super(repository, mapper);
    }

}
