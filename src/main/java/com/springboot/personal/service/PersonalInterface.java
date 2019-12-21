package com.springboot.personal.service;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonalInterface {

  public Flux<Personal> findAll();
  
  public Mono<Personal> findById(String id);
  
  public Mono<Personal> save(Personal personal);
  
  public Mono<Personal> update(PersonalDto personalDto,String id);
  
  public Mono<Void> delete(Personal personal);
  
  public Mono<Personal> saveDto(PersonalDto personalDto);
  
  public Mono<Personal> nameSearch(String name);
  
  public Mono<Personal> findByNumDoc(String numDoc);
  
  public Mono<Personal> findAllAccount(String nameAccount);



}
