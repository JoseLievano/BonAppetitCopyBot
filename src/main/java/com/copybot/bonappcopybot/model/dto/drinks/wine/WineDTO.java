package com.copybot.bonappcopybot.model.dto.drinks.wine;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WineDTO {

    private Long id;

    private String name;

    private String brand;

    private String product;

    private Integer date;

    private String color;

    private String ingredients;

    private String description;

    private List<WineCopyMiniDTO> wineCopies;

}
