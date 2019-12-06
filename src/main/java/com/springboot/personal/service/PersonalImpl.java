package com.springboot.personal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.personal.document.Personal;
import com.springboot.personal.repo.PersonalRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalImpl implements PersonalInterface {
	
	private static final Logger log = LoggerFactory.getLogger(PersonalImpl.class);


	@Autowired
	PersonalRepo repo;

	public Flux<Personal> findAll() {

		return repo.findAll();
	}

	public Mono<Personal> findById(String id) {

		return repo.findById(id);
	}

	public Mono<Personal> save(Personal personal) {

		return repo.save(personal);
	}

	public Mono<Personal> update(Personal personal, String id) {

		return repo.findById(id).flatMap(p -> {

			p.setNumDoc(personal.getNumDoc());
			p.setName(personal.getName());
			p.setApePat(personal.getApePat());
			p.setApeMat(personal.getApeMat());
			p.setAddress(personal.getAddress());
			return repo.save(p);

		});
	}

	public Mono<Void> delete(Personal personal) {
		return repo.delete(personal);
	}

}
