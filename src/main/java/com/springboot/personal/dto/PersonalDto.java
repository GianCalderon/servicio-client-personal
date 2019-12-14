package com.springboot.personal.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class PersonalDto {

  private String idCuenta;
  private String nameAccount;
  private String tipoDoc;
  private String numDoc;
  private String name;
  private String apePat;
  private String apeMat;
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
