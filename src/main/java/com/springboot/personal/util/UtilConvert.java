package com.springboot.personal.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.personal.document.Account;
import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;
import com.springboot.personal.repo.PersonalRepo;


@Component
public class UtilConvert {

  private static final Logger LOGGER = LoggerFactory.getLogger(UtilConvert.class);
	

  public Personal convertPersonal(PersonalDto personalDto) {
	
    LOGGER.info("convertir ---> " + personalDto.toString());

    Account account = new Account();
    account.setIdAccount(personalDto.getIdAccount());
    account.setNumberAccount(personalDto.getNumberAccount());
    account.setNameAccount(personalDto.getNameAccount());
    
    
    Personal personal = new Personal();

    List<Account> listCuenta = new ArrayList<Account>();
    listCuenta.add(account);
    

    personal.setTipoDoc(personalDto.getTipoDoc());
    personal.setNumDoc(personalDto.getNumDoc());
    personal.setName(personalDto.getName()); 
    personal.setApePat(personalDto.getApePat());
    personal.setApeMat(personalDto.getApeMat());
    personal.setAddress(personalDto.getAddress());
    personal.setCreateDate(new Date());
    personal.setUpdateDate(new Date());

    LOGGER.info("TRANSFORMADO ---> "+personal.toString());
    
    LOGGER.info("LISTA_CUENTAS ---> "+listCuenta.toString());
   
    return personal;
  }
  
  

}
