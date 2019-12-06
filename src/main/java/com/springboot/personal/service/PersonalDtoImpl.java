package com.springboot.personal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.personal.document.Personal;
import com.springboot.personal.dto.PersonalDto;

import reactor.core.publisher.Mono;

@Service
public class PersonalDtoImpl {
	
	@Autowired
	PersonalImpl personalImpl;
	
	public Mono<Personal> save(PersonalDto personalDto){

		return personalImpl.save(convertPersonal(personalDto));
		
	}

	public Personal convertPersonal(PersonalDto personalDto) {
		
		Personal personal = new Personal();
		List<String> lista=new ArrayList<String>();
		lista.add(personalDto.getIdCuenta());
		
		personal.setTipoDoc(personalDto.getTipoDoc());
		personal.setNumDoc(personalDto.getNumDoc());
		personal.setName(personalDto.getName());
		personal.setApePat(personalDto.getApePat());
		personal.setApeMat(personalDto.getApeMat());
		personal.setAddress(personalDto.getAddress());
		personal.setIdCuentas(lista);

		return personal;
		
		
	}

}
