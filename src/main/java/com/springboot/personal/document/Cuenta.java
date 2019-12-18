package com.springboot.personal.document;

import lombok.Data;

@Data
public class Cuenta {
	
  private String idAccount;
  private String nameAccount;
  
  public Cuenta(String idAccount, String nameAccount) {
	super();
	this.idAccount = idAccount;
	this.nameAccount = nameAccount;
  }
	
  
}
