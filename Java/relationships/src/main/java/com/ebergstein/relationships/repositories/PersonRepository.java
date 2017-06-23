package com.ebergstein.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
