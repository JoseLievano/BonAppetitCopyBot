package com.copybot.bonappcopybot.model.entity.topic;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String topic;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<TopicCopy> topicCopies = new ArrayList<>();

    public void addCopy(TopicCopy copy){
        topicCopies.add(copy);
    }

    public void removeCopy(TopicCopy copy){
        topicCopies.remove(copy);
    }

}
