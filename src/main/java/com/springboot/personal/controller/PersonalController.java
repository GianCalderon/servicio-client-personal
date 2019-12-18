package com.springboot.personal.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.springboot.personal.dto.PersonalDto;
import com.springboot.personal.dto.PersonalDtoUpdate;
import com.springboot.personal.service.PersonalInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {
	
  private static final Logger LOGGER = LoggerFactory.getLogger(PersonalController.class);


  @Autowired
  PersonalInterface service;

  @GetMapping
  public Mono<ResponseEntity<Flux<Personal>>> toList() {

    return Mono.just(ResponseEntity.ok()
          .contentType(MediaType.APPLICATION_JSON).body(service.findAll()));

  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<Personal>> search(@PathVariable String id) {

    return service.findById(id).map(p -> ResponseEntity.ok()
      .contentType(MediaType.APPLICATION_JSON).body(p))
      .defaultIfEmpty(ResponseEntity.notFound().build());

  }

  @PostMapping
  public Mono<ResponseEntity<Personal>> save(@RequestBody PersonalDto personalDto) {

	
    LOGGER.info("OBJETO RECIBIBIDO ---> " + personalDto.toString());
    
    return service.saveDto(personalDto).map(p -> ResponseEntity.created(URI.create("/api/personal"))
                  .contentType(MediaType.APPLICATION_JSON).body(p));

  }
  
  @PostMapping("/save")
  public Mono<ResponseEntity<Personal>> save(@RequestBody Personal personal) {

    return service.save(personal).map(p -> ResponseEntity.created(URI.create("/api/personal"))
                  .contentType(MediaType.APPLICATION_JSON).body(p));

  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<Personal>> update(@RequestBody Personal personal,
                    @PathVariable String id) {

	  
	  LOGGER.info("OBJETO RECIBIDO A ACTUALIZAR ---> " + personal.toString());
    return service.update(personal, id)
             .map(p -> ResponseEntity.created(URI.create("/api/personal".concat(p.getId())))
             .contentType(MediaType.APPLICATION_JSON).body(p))
             .defaultIfEmpty(ResponseEntity.notFound().build());

  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

    return service.findById(id).flatMap(p -> {
      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

  }
  
//  @GetMapping("/{id}")
//  public Mono<ResponseEntity<Personal>> searchDni(@PathVariable String dni) {
//
//    return service.findByNumDoc(dni).map(p -> ResponseEntity.ok()
//      .contentType(MediaType.APPLICATION_JSON).body(p))
//      .defaultIfEmpty(ResponseEntity.notFound().build());
//
//  }

}
