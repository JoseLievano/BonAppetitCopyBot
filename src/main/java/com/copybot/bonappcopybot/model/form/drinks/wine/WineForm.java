package com.copybot.bonappcopybot.model.form.drinks.wine;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Data
public class WineForm {

    @NotBlank
    private String name;

    @NotBlank
    private String brand;

    @NotBlank
    private String product;

    private Integer date;

    @NotBlank
    private String color;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String description;

}
