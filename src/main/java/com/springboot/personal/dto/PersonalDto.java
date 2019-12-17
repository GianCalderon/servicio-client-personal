package com.springboot.personal.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class PersonalDto {

  @NotNull(message = "User's idCuenta must not be null")
  private String idCuenta;
  
  @NotNull(message = "User's nameAccount must not be null")
  private String nameAccount;
  
  @NotNull(message = "User's tipoDoc must not be null")
  private String tipoDoc;
  
  @NotNull(message = "User's numDoc must not be null")
  private String numDoc;
  
  @NotNull(message = "User's name must not be null")
  private String name;
  
  @NotNull(message = "User's apePat must not be null")
  private String apePat;
  
  @NotNull(message = "User's apeMat must not be null")
  private String apeMat;
  
  @NotNull(message = "User's address must not be null")
  private String address;
  
  
  public PersonalDto(String nameAccount, String tipoDoc, String numDoc, String name, String apePat,
		String apeMat, String address) {
	super();
	this.nameAccount = nameAccount;
	this.tipoDoc = tipoDoc;
	this.numDoc = numDoc;
	this.name = name;
	this.apePat = apePat;
	this.apeMat = apeMat;
	this.address = address;
}



  


 


}
