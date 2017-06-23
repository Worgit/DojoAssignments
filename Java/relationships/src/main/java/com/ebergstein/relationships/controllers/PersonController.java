package com.ebergstein.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.relationships.models.Person;
import com.ebergstein.relationships.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	
	public PersonController(PersonService personService){
		this.personService = personService;
	}
	
	@RequestMapping("/people/new")
	public String newPerson(@ModelAttribute("person") Person person){
		return "newPerson.jsp";
	}
	
	@PostMapping("/people/new")
	public String addPerson(
		@Valid Person person,
        BindingResult result, 
        RedirectAttributes redirectAttributes,
        Model model) {
		if (result.hasErrors()) {
			return "newPerson.jsp";
		}else{
			personService.addPerson(person);
			return "redirect:/people/new";
		}
	}
	@RequestMapping("/people/{id}")
	public String getPerson(@PathVariable("id") Long id, Model model){
		model.addAttribute("person", personService.findPersonById(id));
		return "Person.jsp";
	}
	
	
}
