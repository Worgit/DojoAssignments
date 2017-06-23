package com.ebergstein.countries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebergstein.countries.service.ApiService;

@Controller
public class WorldController {
	
	private ApiService apiService;
	
	public WorldController(ApiService apiService){
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("results", apiService.findCountriesInRegions());
		return "index.jsp";
	}
	
}
