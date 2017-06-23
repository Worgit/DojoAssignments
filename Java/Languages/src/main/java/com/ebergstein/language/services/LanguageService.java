package com.ebergstein.language.services;

/*import java.util.ArrayList;
import java.util.Arrays;*/
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.language.models.Language;
import com.ebergstein.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	
    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return (List<Language>) languageRepository.findAll();
    }
    
    public Language findLanguageById(Long id) {
        return (Language) languageRepository.findOne(id);
    }
    
    public void addLanguage(Language language) {
    	languageRepository.save(language);
    }
    
    public void updateLanguage(Language language) {
    	languageRepository.save(language);
    }
    
    public void destroyLanguage(Long id) {
    	languageRepository.delete(id);
    }
}
