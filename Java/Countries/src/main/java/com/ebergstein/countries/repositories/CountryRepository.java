package com.ebergstein.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.country = c AND l.language = 'Slovene'")
	List<Object[]> findSloveneCountries();
	
	@Query("SELECT c FROM Country c ORDER BY c.cities.size DESC")
	List<Country> findCitiesInCountry();
	
	@Query("SELECT c FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
	List<Country> findSurfaceAndPopulation();
	
	@Query("SELECT c FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.capital > 200 "
			+ "AND c.life_expectancy > 75")
	List<Country> findMonarchyAndCapitalAndLife();
	@Query("SELECT c, COUNT(DISTINCT d) FROM Country c, Country d WHERE c.region = d.region GROUP BY c.region ORDER BY COUNT(d) DESC")
	List<Object[]> findCountriesInRegions();
}
