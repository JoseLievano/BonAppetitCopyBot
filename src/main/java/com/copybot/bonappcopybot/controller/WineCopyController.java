package com.copybot.bonappcopybot.controller;

import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyMiniDTO;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineCopyForm;
import com.copybot.bonappcopybot.service.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("winecopy")
public class WineCopyController extends DefaultController<WineCopyDTO, WineCopyMiniDTO, WineCopyForm, Long> {

    protected WineCopyController(DefaultService<WineCopyDTO, WineCopyMiniDTO, WineCopyForm, Long> service){
        super(service);
    }

}
