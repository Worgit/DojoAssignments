package com.ebergstein.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.relationships.models.License;
import com.ebergstein.relationships.services.LicenseService;
import com.ebergstein.relationships.services.PersonService;

@Controller
public class LicenseController {

	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService){
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license){
		model.addAttribute("people", personService.findAllPeople());
		return "newLicense.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String addLicense(
			@Valid License license,
			BindingResult result, 
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		}else{
			licenseService.addLicense(license);
			return "redirect:/licenses/new";
		}
	}
	
}
