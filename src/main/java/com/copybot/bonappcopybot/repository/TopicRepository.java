package com.copybot.bonappcopybot.repository;

import com.copybot.bonappcopybot.model.entity.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}