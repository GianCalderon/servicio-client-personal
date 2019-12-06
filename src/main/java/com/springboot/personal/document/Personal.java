package com.springboot.personal.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente-personal")
public class Personal {

	@Id
	private String id;
	private String tipoDoc;
	private String numDoc;
	private String name;
	private String apePat;
	private String apeMat;
	private String address;
	private List<String> idCuentas;

	public Personal() {

		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIdCuentas() {
		return idCuentas;
	}

	public void setIdCuentas(List<String> idCuentas) {
		this.idCuentas = idCuentas;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
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

	@Override
	public String toString() {
		return "Personal [id=" + id + ", idCuentas=" + idCuentas + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc
				+ ", name=" + name + ", apePat=" + apePat + ", apeMat=" + apeMat + ", address=" + address + "]";
	}




}
