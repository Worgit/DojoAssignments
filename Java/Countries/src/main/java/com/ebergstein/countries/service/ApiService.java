package com.ebergstein.countries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.countries.models.City;
import com.ebergstein.countries.models.Country;
import com.ebergstein.countries.repositories.CityRepository;
import com.ebergstein.countries.repositories.CountryRepository;
import com.ebergstein.countries.repositories.LanguageRepository;

@Service
public class ApiService {

	private CountryRepository countryRepository;
	private CityRepository cityRepository;
	private LanguageRepository languageRepository;
	
	public ApiService(CountryRepository countryRepository, CityRepository cityRepository, LanguageRepository languageRepository){
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.languageRepository = languageRepository;
	}
	
	public List<Object[]> findSlovene(){
		return (List<Object[]>) countryRepository.findSloveneCountries();
	}
	
	public List<Country> findCities(){
		return (List<Country>) countryRepository.findCitiesInCountry();
	}
	
	public List<City> findBigCitiesInMexico(){
		return (List<City>) cityRepository.findBigCitiesInMexico();
	}
	
	public List<Object[]> findLanguagePercentages(){
		return (List<Object[]>) languageRepository.findLanguagePercantages();
	}
	
	public List<Country> findSurfaceAndPopulation(){
		return (List<Country>) countryRepository.findSurfaceAndPopulation();
	}
	
	public List<Country> findMonarchyAndCapitalAndLife(){
		return (List<Country>) countryRepository.findMonarchyAndCapitalAndLife();
	}
	
	public List<Object[]> findBigCitiesInBuenosAires(){
		return (List<Object[]>) cityRepository.findBigCitiesInBuenosAires();
	}
	
	public List<Object[]> findCountriesInRegions(){
		return (List<Object[]>) countryRepository.findCountriesInRegions();
	}
}
