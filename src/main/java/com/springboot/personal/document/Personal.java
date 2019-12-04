package com.springboot.personal.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cliente-personal")
public class Personal {
	
	private String id;
	private String dni;
	private String name;
	private String apePat;
	private String apeMat;
	private String address;
	
	
	public Personal(String dni, String name, String apePat, String apeMat, String address) {
		super();
		this.dni = dni;
		this.name = name;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.address = address;
	}

	public Personal() {
	
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
