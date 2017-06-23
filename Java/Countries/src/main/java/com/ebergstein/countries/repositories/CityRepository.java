package com.ebergstein.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	@Query("SELECT c FROM City c JOIN c.country i WHERE i.name = 'Mexico' AND c.population > 500000 ORDER BY c.population DESC")
	List<City> findBigCitiesInMexico();
	@Query("SELECT c, i FROM City c JOIN c.country i WHERE i.name = 'Argentina' AND c.population > 500000 "
			+ "AND c.district = 'Buenos Aires'")
	List<Object[]> findBigCitiesInBuenosAires();

	
}
