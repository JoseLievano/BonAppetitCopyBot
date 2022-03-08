package com.copybot.bonappcopybot.model.dto.topic;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TopicDTO {

    private Long id;

    private String topic;

    private List<TopicCopyMiniDTO> topicCopies = new ArrayList<>();

}
