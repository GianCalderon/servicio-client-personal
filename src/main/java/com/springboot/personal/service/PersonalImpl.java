package com.springboot.personal.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;
import com.springboot.personal.dto.PersonalDtoUpdate;
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

  public Mono<Personal> update(Personal personal,String id) {

    return repo.findById(id).flatMap(p -> {

      p.setNumDoc(personal.getNumDoc());
      p.setName(personal.getName());
      p.setApePat(personal.getApePat());
      p.setApeMat(personal.getApeMat());
      p.setAddress(personal.getAddress());
      p.setUpdateDate(new Date());
      p.setIdCuentas(personal.getIdCuentas());
      
      return repo.save(p);

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
  
  public Mono<Personal> report(String numDoc) {

//	    return repo.findByNumDoc(numDoc).flatMap(p->{
//	    	
//	    	p.getIdCuentas().forEach(p->p.get(key));
//	    	
//	    	
//	    })
	  
	  return null;
	    
	  }


}
