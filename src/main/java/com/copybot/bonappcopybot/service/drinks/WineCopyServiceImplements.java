package com.copybot.bonappcopybot.service.drinks;

import com.copybot.bonappcopybot.exeptions.ElementNotFoundExeption;
import com.copybot.bonappcopybot.mapper.drinks.wine.WineCopyMapper;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyMiniDTO;
import com.copybot.bonappcopybot.model.entity.drinks.wine.Wine;
import com.copybot.bonappcopybot.model.entity.drinks.wine.WineCopy;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineCopyForm;
import com.copybot.bonappcopybot.openai.WineCopyAI;
import com.copybot.bonappcopybot.repository.WineCopyRepository;
import com.copybot.bonappcopybot.repository.WineRepository;
import com.copybot.bonappcopybot.service.defaultService.DefaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WineCopyServiceImplements extends DefaultServiceImpl<WineCopyDTO, WineCopyMiniDTO, WineCopyForm, WineCopy, Long> {

    @Autowired
    private WineRepository wineRepository;

    public WineCopyServiceImplements(WineCopyRepository repository, WineCopyMapper mapper){
        super(repository, mapper);
    }

    @Override
    public WineCopyMiniDTO insert(WineCopyForm form) throws ElementNotFoundExeption {

        if (form == null){
            return null;
        }

        WineCopy toInsert = mapper.toEntity(form);

        Wine wine = wineRepository.getById(form.getWine());

        toInsert.setWine(wine);

        WineCopyAI copyAI = WineCopyAI.getInstance();

        toInsert.setCopy(copyAI.getWineCopy(wine, toInsert));

        repository.save(toInsert);

        wine.addCopy(toInsert);
        wineRepository.save(wine);

        return mapper.toSmallDTO(toInsert);

    }
}
