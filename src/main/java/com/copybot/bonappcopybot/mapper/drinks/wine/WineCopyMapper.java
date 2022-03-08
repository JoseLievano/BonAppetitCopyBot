package com.copybot.bonappcopybot.mapper.drinks.wine;

import com.copybot.bonappcopybot.mapper.DefaultMapper;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineCopyMiniDTO;
import com.copybot.bonappcopybot.model.entity.drinks.wine.WineCopy;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineCopyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class WineCopyMapper implements DefaultMapper<WineCopyDTO, WineCopyMiniDTO, WineCopyForm, WineCopy> {

    @Lazy
    @Autowired
    private WineMapper wineMapper;

    @Override
    public WineCopyDTO toDTO(WineCopy entity) {
        if (entity == null){
            return null;
        }

        return WineCopyDTO.builder()
                .id(entity.getId())
                .lang(entity.getLang())
                .wine(wineMapper.toSmallDTO(entity.getWine()))
                .copy(entity.getCopy())
                .occasion(entity.getOccasion())
                .build();
    }

    @Override
    public WineCopyMiniDTO toSmallDTO(WineCopy entity) {
        if (entity == null){
            return null;
        }

        return WineCopyMiniDTO.builder()
                .id(entity.getId())
                .lang(entity.getLang())
                .copy(entity.getCopy())
                .occasion(entity.getOccasion())
                .build();
    }

    @Override
    public WineCopy toEntity(WineCopyForm form) {

        if (form == null){
            return null;
        }

        return WineCopy.builder()
                .lang(form.getLang())
                .occasion(form.getOccasion())
                .build();
    }

}
