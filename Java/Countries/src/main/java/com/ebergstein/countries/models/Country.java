package com.ebergstein.countries.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue
    private Long id;
	@Size(max = 3)
	private String code;
	@Size(max = 52)
	private String name;
	private String continent;
	@Size(max = 26)
	private String region;
	private Float surface_area;
	private Short indep_year;
	private Integer population;
	private Float life_expectancy;
	private Float gnp;
	private Float gnp_old;
	@Size(max = 45)
	private String local_name;
	@Size(max = 45)
	private String government_form;
	@Size(max = 60)
	private String head_of_state;
	private Float capital;
	//@Size(max = 2)
	private String code2;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	
	public Country(){
		
	}
	
	public Country(String code,
			String name,
			String continent,
			String region,
			Float surface_area,
			Short indep_year,
			Integer population,
			Float life_expectancy,
			Float gnp,
			Float gnp_old,
			String local_name,
			String government_form,
			String head_of_state,
			Float capital,
			String code2){
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(float surface_area) {
		this.surface_area = surface_area;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public float getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public float getGnp() {
		return gnp;
	}

	public void setGnp(float gnp) {
		this.gnp = gnp;
	}

	public float getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(float gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public Float getCapital() {
		return capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
