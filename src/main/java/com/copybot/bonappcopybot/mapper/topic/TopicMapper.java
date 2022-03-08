package com.copybot.bonappcopybot.mapper.topic;

import com.copybot.bonappcopybot.mapper.DefaultMapper;
import com.copybot.bonappcopybot.model.dto.topic.TopicDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicMiniDTO;
import com.copybot.bonappcopybot.model.entity.topic.Topic;
import com.copybot.bonappcopybot.model.form.topic.TopicForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TopicMapper implements DefaultMapper<TopicDTO, TopicMiniDTO, TopicForm, Topic> {

    @Lazy
    @Autowired
    private TopicCopyMapper topicCopyMapper;

    @Override
    public TopicDTO toDTO(Topic entity) {

        if (entity == null)
            return null;

        return TopicDTO.builder()
                .id(entity.getId())
                .topic(entity.getTopic())
                .topicCopies(entity.getTopicCopies().stream()
                        .map(topicCopyMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @Override
    public TopicMiniDTO toSmallDTO(Topic entity) {

        if (entity == null)
            return null;

        return TopicMiniDTO.builder()
                .id(entity.getId())
                .topic(entity.getTopic())
                .build();

    }

    @Override
    public Topic toEntity(TopicForm form) {

        if (form == null)
            return null;

        return Topic.builder()
                .topic(form.getTopic())
                .build();

    }
}
