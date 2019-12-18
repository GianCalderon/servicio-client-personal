package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;


@Component
public class UtilConvert {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilConvert.class);
	
	
  public Personal convertPersonal(PersonalDto personalDto) {
	
    LOGGER.info("convertir ---> " + personalDto.toString());

    Map<String,String> cuentaMap = new HashMap<String,String>();
    Personal personal = new Personal();

    cuentaMap.put(personalDto.getIdAccount(), personalDto.getNameAccount());

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

    LOGGER.info("TRANSFORMADO ---> "+personal.toString());
   
    return personal;
  }
  
  

}
