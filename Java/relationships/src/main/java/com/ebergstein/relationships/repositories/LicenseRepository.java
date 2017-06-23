package com.ebergstein.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	License findTop1ByOrderByIdDesc();
}
