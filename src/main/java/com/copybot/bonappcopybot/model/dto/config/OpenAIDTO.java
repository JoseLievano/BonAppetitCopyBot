package com.copybot.bonappcopybot.model.dto.config;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OpenAIDTO {

    private Long id;

    private String APIKEY;

}
