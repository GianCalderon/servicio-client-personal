package com.springboot.personal.repo;

import com.springboot.personal.document.Personal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonalRepo extends ReactiveMongoRepository<Personal,String> {

}
