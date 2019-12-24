package com.springboot.personal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalDto {

	private String idAccount;
	private String numberAccount;
	private String nameAccount;
	

	private String tipoDoc;
	private String numDoc;
	private String name;
	private String apePat;
	private String apeMat;
	private String address;

	
}
