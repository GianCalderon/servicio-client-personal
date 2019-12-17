package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;

@Component
public class UtilConvert {

  public Personal convertPersonal(PersonalDto personalDto) {

    Map<String,String> cuentaMap = new HashMap<String,String>();
    Personal personal = new Personal();

    cuentaMap.put(personalDto.getNameAccount(), personalDto.getIdCuenta());
    List<Map<String,String>> lista = new ArrayList<Map<String,String>>();
    lista.add(cuentaMap);

  
    personal.setTipoDoc(personalDto.getTipoDoc());
    personal.setNumDoc(personalDto.getNumDoc());
    personal.setName(personalDto.getName()); 
    personal.setApePat(personalDto.getApePat());
    personal.setApeMat(personalDto.getApeMat());
    personal.setAddress(personalDto.getAddress());
    personal.setCreateDate(new Date());
    personal.setUpdateDate(new Date());
    personal.setIdCuentas(lista);

    return personal;
  }

}
