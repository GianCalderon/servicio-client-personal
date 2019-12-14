package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.personal.document.Cuenta;
import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;

@Component
public class UtilConvert {

  public Personal convertPersonal(PersonalDto personalDto) {

    Cuenta cuenta = new Cuenta();
    cuenta.setNumAccount(personalDto.getIdCuenta());
    cuenta.setDetailAccount(personalDto.getNameAccount());

    Personal personal = new Personal();

    List<Cuenta> lista = new ArrayList<Cuenta>();
    
    lista.add(cuenta);

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
