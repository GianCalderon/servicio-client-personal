package com.springboot.personal;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;
import com.springboot.personal.service.PersonalInterface;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootServicioClientPersonaApplicationTests {

  @Autowired
  private WebTestClient client;
  
  @Autowired
  private PersonalInterface service;



  @Test
  public void listTest() {

    client.get()
    .uri("api/personal")
    .accept(MediaType.APPLICATION_JSON)
    .exchange()
    .expectStatus().isOk()
    .expectHeader().contentType(MediaType.APPLICATION_JSON)
      .expectBodyList(Personal.class);
  }

  @Test
  public void searchTest() {


    Personal personal = service.nameSearch("Rosa").block();

    client.get()
    .uri("api/personal/{id}",Collections.singletonMap("id", personal.getId()))
    .accept(MediaType.APPLICATION_JSON)
    .exchange()
    .expectStatus().isOk()
    .expectHeader().contentType(MediaType.APPLICATION_JSON)
    .expectBody()
    .jsonPath("$.id").isNotEmpty()
    .jsonPath("$.name").isEqualTo("Rosa");
      
  }
  

  @Test
  public void saveTest() {


    PersonalDto personalDto = new PersonalDto("1deaes79067db969b8fffc13","dni","8966675",
                                        "Alberto","Calderon","Humareda","Rosale 234");

    client.post()
    .uri("api/personal")
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON)
    .body(Mono.just(personalDto),PersonalDto.class)
    .exchange()
    .expectStatus().isCreated()
    .expectHeader().contentType(MediaType.APPLICATION_JSON)
      .expectBody()
      .jsonPath("$.id").isNotEmpty()
      .jsonPath("$.name").isEqualTo("Alberto");
  }
  
  @Test
  public void updateTest() {


    Personal personal = service.nameSearch("Mariano").block();
    Personal personalEditado = new Personal("dni","72316897",
                                        "Emmanuel","Calderon","Humareda","España 234");

    client.put()
          .uri("api/personal/{id}",Collections.singletonMap("id", personal.getId()))
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
          .body(Mono.just(personalEditado),Personal.class)
          .exchange()
          .expectStatus().isCreated()
          .expectHeader().contentType(MediaType.APPLICATION_JSON)
          .expectBody()
          .jsonPath("$.id").isNotEmpty()
          .jsonPath("$.name").isEqualTo("Emmanuel");
  }
  
  @Test
  public void delete() {
  
    Personal personal = service.nameSearch("Alberto").block();

    client.delete()
    .uri("api/personal/{id}",Collections.singletonMap("id",personal.getId()))
    .exchange()
    .expectStatus().isAccepted()
    .expectBody()
      .isEmpty();

  }
  

}
