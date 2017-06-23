package com.ebergstein.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.relationships.models.Person;
import com.ebergstein.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}
	
	public List<Person> findAllPeople(){
		return (List<Person>) personRepository.findAll();
	}
	
	public Person findPersonById(long id){
		return (Person) personRepository.findOne(id);
	}
	
	public void addPerson(Person person){
		personRepository.save(person);
	}
	
}
