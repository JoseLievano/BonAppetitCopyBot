package com.copybot.bonappcopybot.model.dto.topic;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TopicCopyDTO {

    private Long id;

    private String occasion;

    private String lang;

    private String copy;

    private TopicMiniDTO topic;

}
