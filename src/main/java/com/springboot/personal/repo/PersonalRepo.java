package com.springboot.personal.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.personal.document.Personal;

import reactor.core.publisher.Mono;

public interface PersonalRepo extends ReactiveMongoRepository<Personal,String> {

  public Mono<Personal> findByName(String name);

//  @Query("{'numDoc': ?0 }")
//  public Mono<Personal> findByNumDoc(String numDoc);

  public Mono<Personal> findByNumDoc(String numDoc);
  
  @Query("{'idCuentas.idCuenta': ?0 }")
  public Mono<Personal>searchAccount(String nameAccount);

  
      

  
}
