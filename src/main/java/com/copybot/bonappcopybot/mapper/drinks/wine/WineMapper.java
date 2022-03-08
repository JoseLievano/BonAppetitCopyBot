package com.copybot.bonappcopybot.mapper.drinks.wine;

import com.copybot.bonappcopybot.mapper.DefaultMapper;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineDTO;
import com.copybot.bonappcopybot.model.dto.drinks.wine.WineMiniDTO;
import com.copybot.bonappcopybot.model.entity.drinks.wine.Wine;
import com.copybot.bonappcopybot.model.form.drinks.wine.WineForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class WineMapper implements DefaultMapper<WineDTO, WineMiniDTO, WineForm, Wine> {

    @Lazy
    @Autowired
    private WineCopyMapper copyMapper;

    @Override
    public WineDTO toDTO(Wine entity) {

        if (entity == null){
            return null;
        }

        return WineDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .product(entity.getProduct())
                .date(entity.getDate())
                .color(entity.getColor())
                .ingredients(entity.getIngredients())
                .description(entity.getDescription())
                .wineCopies(entity.getWineCopies().stream()
                        .map(copyMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @Override
    public WineMiniDTO toSmallDTO(Wine entity) {

        if (entity == null){
            return null;
        }

        return WineMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .product(entity.getProduct())
                .date(entity.getDate())
                .color(entity.getColor())
                .ingredients(entity.getIngredients())
                .description(entity.getDescription())
                .build();

    }

    @Override
    public Wine toEntity(WineForm form) {

        if (form == null){
            return null;
        }

        return Wine.builder()
                .name(form.getName())
                .brand(form.getBrand())
                .product(form.getProduct())
                .date(form.getDate())
                .color(form.getColor())
                .ingredients(form.getIngredients())
                .description(form.getDescription())
                .build();

    }
}
