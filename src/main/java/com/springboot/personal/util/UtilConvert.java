package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;

@Component
public class UtilConvert {
	
  public Personal convertPersonal(PersonalDto personalDto) {

    Personal personal = new Personal();
    List<String> lista = new ArrayList<String>();
    lista.add(personalDto.getIdCuenta());

    personal.setTipoDoc(personalDto.getTipoDoc());
    personal.setNumDoc(personalDto.getNumDoc());
    personal.setName(personalDto.getName()); 
    personal.setApePat(personalDto.getApePat());
    personal.setApeMat(personalDto.getApeMat());
    personal.setAddress(personalDto.getAddress());
    personal.setIdCuentas(lista);

    return personal;
  }

}
