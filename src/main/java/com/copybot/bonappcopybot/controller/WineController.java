package com.copybot.bonappcopybot.controller;

import com.copybot.bonappcopybot.model.dto.drinks.wine.WineDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineMiniDTO;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineForm;
import com.copybot.bonappcopybot.service.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wine")
public class WineController extends DefaultController<WineDTO, WineMiniDTO, WineForm, Long>{

    protected WineController(DefaultService<WineDTO, WineMiniDTO, WineForm, Long> service){
        super(service);
    }

}
