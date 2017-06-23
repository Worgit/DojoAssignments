package com.ebergstein.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ebergstein.relationships.models.Dojo;
import com.ebergstein.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	private static final int PAGE_SIZE = 5;
	
	public DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> findAll(){
		return (List<Dojo>) dojoRepository.findAll();
	}
	
	public Dojo findOne(long id){
		return (Dojo) dojoRepository.findOne(id);
	}
	
	public void addDojo(Dojo dojo){
		dojoRepository.save(dojo);
	}
	
    public Page<Object[]> dojosandninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Object[]> dojosandninjas = dojoRepository.pageDojosAndNinjas(pageRequest);
        return dojoRepository.pageDojosAndNinjas(pageRequest);
    }

}
