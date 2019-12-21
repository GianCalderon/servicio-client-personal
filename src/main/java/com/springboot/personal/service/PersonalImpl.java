package com.springboot.personal.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.personal.document.Cuenta;
import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;
import com.springboot.personal.repo.PersonalRepo;
import com.springboot.personal.util.UtilConvert;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalImpl implements PersonalInterface {


  private static final Logger LOGGER = LoggerFactory.getLogger(PersonalImpl.class);

  @Autowired
  PersonalRepo repo;

  @Autowired
  UtilConvert convert;

  public Flux<Personal> findAll() {

    return repo.findAll();
  }

  public Mono<Personal> findById(String id) {

    return repo.findById(id);
  }

  public Mono<Personal> save(Personal personal) {

	  personal.setCreateDate(new Date());
	  personal.setUpdateDate(new Date());
	
      return repo.save(personal);
  }

  public Mono<Personal> update(PersonalDto personalDto,String id) {

    return repo.findByNumDoc(id).flatMap(persona -> {
  	
      List<Cuenta> list = persona.getIdCuentas();
      
      Cuenta cuenta = new Cuenta();
      
      cuenta.setIdAccount(personalDto.getIdAccount());
      cuenta.setNameAccount(personalDto.getNameAccount());
      cuenta.setIdCuenta(personalDto.getIdCuenta());
      
      list.add(cuenta);
      
     
      persona.setTipoDoc(personalDto.getTipoDoc());
      persona.setNumDoc(personalDto.getNumDoc());
      persona.setName(personalDto.getName());
      persona.setApePat(personalDto.getApePat());
      persona.setApeMat(personalDto.getApeMat());
      persona.setAddress(personalDto.getAddress());
      persona.setUpdateDate(new Date());
      persona.setIdCuentas(list);
      
      return repo.save(persona);
  
    });
  }

  public Mono<Void> delete(Personal personal) {
    return repo.delete(personal);
  }

  public Mono<Personal> saveDto(PersonalDto personalDto) {

    return save(convert.convertPersonal(personalDto));
  }

  @Override
  public Mono<Personal> nameSearch(String name) {

    return repo.findByName(name);
  }

  @Override
  public Mono<Personal> findByNumDoc(String numDoc) {

    return repo.findByNumDoc(numDoc);
  }
  
  @Override
  public Mono<Personal> findAllAccount(String nameAccount) {

    return repo.searchAccount(nameAccount);
  }
  


}
