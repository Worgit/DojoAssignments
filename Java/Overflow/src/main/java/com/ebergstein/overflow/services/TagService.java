package com.ebergstein.overflow.services;

import org.springframework.stereotype.Service;

import com.ebergstein.overflow.models.Tag;
import com.ebergstein.overflow.repositories.TagRepository;

@Service
public class TagService {
	
	private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository){
		this.tagRepository = tagRepository;
	}
	
	public Tag findTagBySubject(String subject){
		return (Tag) tagRepository.findBySubject(subject);
	}
	
	public void addTag(Tag tag){
		tagRepository.save(tag);
	}

}
