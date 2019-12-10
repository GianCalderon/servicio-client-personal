package com.springboot.personal.repo;

import com.springboot.personal.document.Personal;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface PersonalRepo extends ReactiveMongoRepository<Personal,String> {

  public Mono<Personal> findByName(String name);

  @Query("{'nombre': ?0 }")
  public Mono<Personal> nameSearch(String name);


}
