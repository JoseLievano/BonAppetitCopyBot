package com.copybot.bonappcopybot.service.topic;

import com.copybot.bonappcopybot.exeptions.ElementNotFoundExeption;
import com.copybot.bonappcopybot.mapper.topic.TopicCopyMapper;
import com.copybot.bonappcopybot.model.dto.topic.TopicCopyDTO;
import com.copybot.bonappcopybot.model.dto.topic.TopicCopyMiniDTO;
import com.copybot.bonappcopybot.model.entity.topic.Topic;
import com.copybot.bonappcopybot.model.entity.topic.TopicCopy;
import com.copybot.bonappcopybot.model.form.topic.TopicCopyForm;
import com.copybot.bonappcopybot.openai.TopicCopyAI;
import com.copybot.bonappcopybot.repository.TopicCopyRepository;
import com.copybot.bonappcopybot.repository.TopicRepository;
import com.copybot.bonappcopybot.service.defaultService.DefaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicCopyServiceImplements extends DefaultServiceImpl<TopicCopyDTO, TopicCopyMiniDTO, TopicCopyForm, TopicCopy, Long> {

    @Autowired
    private TopicRepository topicRepository;

    public TopicCopyServiceImplements(TopicCopyRepository repository, TopicCopyMapper mapper){
        super(repository, mapper);
    }

    @Override
    public TopicCopyMiniDTO insert(TopicCopyForm form) throws ElementNotFoundExeption {
        if (form == null)
            return null;

        TopicCopy toInsert = mapper.toEntity(form);

        Topic topic = topicRepository.getById(form.getTopic());

        toInsert.setTopic(topic);

        TopicCopyAI topicAI = TopicCopyAI.getInstance();

        toInsert.setCopy(topicAI.getCopy(topic,toInsert));

        repository.save(toInsert);

        topic.addCopy(toInsert);

        topicRepository.save(topic);

        return mapper.toSmallDTO(toInsert);

    }
}
