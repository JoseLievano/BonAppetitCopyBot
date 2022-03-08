package com.copybot.bonappcopybot.mapper.topic;

import com.copybot.bonappcopybot.mapper.DefaultMapper;
import com.copybot.bonappcopybot.model.dto.topic.TopicCopyDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicCopyMiniDTO;
import com.copybot.bonappcopybot.model.entity.topic.TopicCopy;
import com.copybot.bonappcopybot.model.form.topic.TopicCopyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class TopicCopyMapper implements DefaultMapper<TopicCopyDTO, TopicCopyMiniDTO, TopicCopyForm, TopicCopy> {

    @Lazy
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public TopicCopyDTO toDTO(TopicCopy entity) {

        if (entity == null)
            return null;

        return TopicCopyDTO.builder()
                .id(entity.getId())
                .lang(entity.getLang())
                .occasion(entity.getOccasion())
                .topic(topicMapper.toSmallDTO(entity.getTopic()))
                .copy(entity.getCopy())
                .build();

    }

    @Override
    public TopicCopyMiniDTO toSmallDTO(TopicCopy entity) {

        if (entity == null){
            return null;
        }

        return TopicCopyMiniDTO.builder()
                .id(entity.getId())
                .lang(entity.getLang())
                .occasion(entity.getOccasion())
                .copy(entity.getCopy())
                .build();

    }

    @Override
    public TopicCopy toEntity(TopicCopyForm form) {

        if (form == null)
            return null;

        return TopicCopy.builder()
                .occasion(form.getOccasion())
                .lang(form.getLang())
                .build();
    }
}
