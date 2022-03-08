package com.copybot.bonappcopybot.model.form.drinks.wine;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Validated
@Data
public class WineCopyForm {

    private String occasion;

    private String lang;

    private Long wine;

}
