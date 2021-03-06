package com.ebergstein.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue
    private Long id;
	@Size(max = 3)
	private String country_code;
	@Size(max = 30)
	private String language;
	private Boolean is_official;
	private float percentage;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
	private Country country;
	
	public Language(){
		
	}
	
	public Language(String country_code,
			String language,
			Boolean is_official,
			float percentage){
		this.country_code = country_code;
		this.language = language;
		this.is_official = is_official;
		this.percentage = percentage;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Boolean getIs_official() {
		return is_official;
	}
	public void setIs_official(Boolean is_official) {
		this.is_official = is_official;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
