package com.ebergstein.relationships.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.relationships.models.Dojo;
import com.ebergstein.relationships.services.DojoService;
import com.ebergstein.relationships.services.NinjaService;

@Controller
public class DojoController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService){
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
	public String welcome(@ModelAttribute("dojo") Dojo dojo){
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(
			@Valid Dojo dojo,
			BindingResult result, 
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}else{
			dojoService.addDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String getNinjas(@PathVariable("id") Long id, Model model){
		model.addAttribute("ninjas", ninjaService.findNinjasByDojo(id));
		model.addAttribute("dojo", dojoService.findOne(id));
		return "Dojo.jsp";
	}
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
	    Page<Object[]> results = dojoService.dojosandninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = results.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("results", results);
	    return "dojosandninjas.jsp";
	}
}
