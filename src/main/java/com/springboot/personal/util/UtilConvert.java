package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.springboot.personal.document.Cuenta;
import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;


@Component
public class UtilConvert {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilConvert.class);
	
	
  public Personal convertPersonal(PersonalDto personalDto) {
	
    LOGGER.info("convertir ---> " + personalDto.toString());

    Cuenta cuenta = new Cuenta();
    cuenta.setIdAccount(personalDto.getIdAccount());
    cuenta.setNameAccount(personalDto.getNameAccount());
    
    Personal personal = new Personal();
  
    List<Cuenta> listCuenta = new ArrayList<Cuenta>();
    listCuenta.add(cuenta);
    

    personal.setTipoDoc(personalDto.getTipoDoc());
    personal.setNumDoc(personalDto.getNumDoc());
    personal.setName(personalDto.getName()); 
    personal.setApePat(personalDto.getApePat());
    personal.setApeMat(personalDto.getApeMat());
    personal.setAddress(personalDto.getAddress());
    personal.setCreateDate(new Date());
    personal.setUpdateDate(new Date());
    personal.setIdCuentas(listCuenta);

    LOGGER.info("TRANSFORMADO ---> "+personal.toString());
   
    return personal;
  }
  
  

}
