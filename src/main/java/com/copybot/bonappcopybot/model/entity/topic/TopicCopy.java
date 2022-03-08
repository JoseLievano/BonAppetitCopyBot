package com.copybot.bonappcopybot.model.entity.topic;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopicCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String occasion;

    @Column
    private String lang;

    @Column
    private String copy;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

}
