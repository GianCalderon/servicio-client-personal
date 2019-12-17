package com.springboot.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioClientPersonaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootServicioClientPersonaApplication.class,args);
  }

}
