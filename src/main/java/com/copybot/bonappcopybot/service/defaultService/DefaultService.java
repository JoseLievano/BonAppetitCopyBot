package com.copybot.bonappcopybot.service.defaultService;

import com.copybot.bonappcopybot.exeptions.ElementNotFoundExeption;

import java.util.List;

public interface DefaultService <DTO, MINIDTO, FORM, ID>{

    DTO getOne(ID id) throws ElementNotFoundExeption;

    List<DTO> getAll();

    MINIDTO insert(FORM form) throws ElementNotFoundExeption;

    DTO update(ID id, FORM form) throws ElementNotFoundExeption;

    DTO delete (ID id) throws ElementNotFoundExeption;

}
