package com.springboot.personal.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.personal.document.Personal;

public interface PersonalRepo extends ReactiveMongoRepository<Personal,String> {

}
