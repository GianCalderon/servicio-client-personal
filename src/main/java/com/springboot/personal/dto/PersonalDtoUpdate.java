package com.springboot.personal.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PersonalDtoUpdate {

  private String idAccount;
  
  private String nameAccount;
  
  private String tipoDoc;

  private String numDoc;

  private String name;

  private String apePat;

  private String apeMat;

  private String address;
  
	private List<Map<String,String>> idCuentas;
  
  
  public PersonalDtoUpdate(String nameAccount, String tipoDoc, String numDoc, String name, String apePat,
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
