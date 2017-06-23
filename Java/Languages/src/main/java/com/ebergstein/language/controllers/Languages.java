package com.ebergstein.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.language.models.Language;
import com.ebergstein.language.services.LanguageService;


@Controller
public class Languages {
    private final LanguageService languageService;
    
    public Languages(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String languages(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages.jsp";
    }
    
    @RequestMapping("/languages/{index}")
    public String findLanguageByIndex(@PathVariable("index") Long index, Model model) {
        model.addAttribute("language", languageService.findLanguageById(index));
        return "language.jsp";
    }
    
    @PostMapping("/languages/new")
    public String createLanguage(
            @Valid Language language,
            BindingResult result, 
            RedirectAttributes redirectAttributes,
            Model model) {
        if (result.hasErrors()) {
        	//redirectAttributes.addFlashAttribute("language", language);
        	List<Language> languages = languageService.allLanguages();
            model.addAttribute("languages", languages);
        	return "languages.jsp";
        }else{
        	languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/edit/{id}")
    public String editLanguages(
            @PathVariable("id") Long id,
            Model model) {
            Language language = languageService.findLanguageById(id);
            if (language != null){
                model.addAttribute("language", language);
                return "editLanguage.jsp";
            }else{
                return "redirect:/languages";
            }
    }
    
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(
    		@PathVariable("id") int id,
            @Valid Language language,
            BindingResult result) {
        if (result.hasErrors()) {
        	return "editLanguage.jsp";
        }else{
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
    }
}
