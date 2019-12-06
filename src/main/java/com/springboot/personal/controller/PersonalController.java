package com.springboot.personal.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.personal.document.Personal;
import com.springboot.personal.service.PersonalInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {


  @Autowired
  PersonalInterface service;
 
  @GetMapping
  public Mono<ResponseEntity<Flux<Personal>>> toList() {

    return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
    		.body(service.findAll()));

  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Personal>> search(@PathVariable String id) {

    return service.findById(id).map(p->ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@PostMapping
	public Mono<ResponseEntity<Personal>> save(@RequestBody Personal personal) {
	

		return service.save(personal).map(p->ResponseEntity
				.created(URI.create("/api/personal".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p));

	}

	@PutMapping("/{id}")
	public Mono<ResponseEntity<Personal>> update(@RequestBody Personal personal, @PathVariable String id) {

		return service.update(personal, id).map(p->ResponseEntity
						.created(URI.create("/api/personal".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
			
	
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
		
		return service.findById(id).flatMap(p->{
			return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

		
	}

}
