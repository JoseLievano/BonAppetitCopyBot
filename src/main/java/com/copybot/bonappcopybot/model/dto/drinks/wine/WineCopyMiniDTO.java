package com.copybot.bonappcopybot.model.dto.drinks.wine;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WineCopyMiniDTO {

    private Long id;

    private String occasion;

    private String lang;

    private String copy;

}
