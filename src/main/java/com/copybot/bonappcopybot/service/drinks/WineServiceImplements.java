package com.copybot.bonappcopybot.service.drinks;

import com.copybot.bonappcopybot.mapper.drinks.wine.WineMapper;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineMiniDTO;
import com.copybot.bonappcopybot.model.entity.drinks.wine.Wine;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineForm;
import com.copybot.bonappcopybot.repository.WineRepository;
import com.copybot.bonappcopybot.service.defaultService.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImplements extends DefaultServiceImpl <WineDTO, WineMiniDTO, WineForm, Wine, Long> {

    public WineServiceImplements(WineRepository repository, WineMapper mapper){
        super(repository, mapper);
    }

}
