package com.ebergstein.relationships.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebergstein.relationships.models.Dojo;
import com.ebergstein.relationships.models.Ninja;
import com.ebergstein.relationships.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepository;
	private static final int PAGE_SIZE = 5;
	
	public NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> findNinjasByDojo(long id){
		return (List<Ninja>) ninjaRepository.findByDojoId(id);
	}
	
	public void addNinja(Ninja ninja){
		ninjaRepository.save(ninja);
	}
	
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        Page<Ninja> ninjas = ninjaRepository.findAll(pageRequest);
        return ninjaRepository.findAll(pageRequest);
    }
}
