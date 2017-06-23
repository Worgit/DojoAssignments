package com.ebergstein.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.relationships.models.License;
import com.ebergstein.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {

	private LicenseRepository licenceRepository;
	
	public LicenseService(LicenseRepository licenceRepository){
		this.licenceRepository = licenceRepository;
	}
	
	public License findTop1ByOrderByIdDesc(){
		return (License) licenceRepository.findTop1ByOrderByIdDesc();
	}
	
	public void addLicense(License license){
		License temp = findTop1ByOrderByIdDesc();
		Long raw = temp.getId() + 1;
		if(raw < 10){
			license.setNumber("00000" + raw.toString());
		}
		else if (raw < 100){
			license.setNumber("0000" + raw.toString());
		}
		else if (raw < 1000){
			license.setNumber("000" + raw.toString());
		}
		else if (raw < 10000){
			license.setNumber("00" + raw.toString());
		}
		else if (raw < 100000){
			license.setNumber("0" + raw.toString());
		}
		else{
			license.setNumber(raw.toString());
		}
		licenceRepository.save(license);
	}
	
}
