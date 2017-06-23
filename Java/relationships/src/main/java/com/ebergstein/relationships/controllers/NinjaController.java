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

import com.ebergstein.relationships.models.Ninja;
import com.ebergstein.relationships.services.DojoService;
import com.ebergstein.relationships.services.NinjaService;

@Controller
public class NinjaController {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService){
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model){
		model.addAttribute("dojos", dojoService.findAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("ninjas/new")
	public String addNinja(
			@Valid Ninja ninja,
			BindingResult result, 
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			return "newNinja.jsp";
		}else{
			ninjaService.addNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	/*
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
	    Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}*/


}
