package com.ebergstein.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.relationships.models.Category;
import com.ebergstein.relationships.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findCategoriesNotInCategoryList(List<Category> categories){
		List<Category> all = (List<Category>) categoryRepository.findAll();
		//System.out.println(all.size());
		for(int i = 0; i < all.size(); i++){
			if(categories.contains(all.get(i))){
				all.remove(i);
				i--;
			}
		}
		//System.out.println(all.size());
		return all;				
	}
	
	public Category findCategoryById(long id){
		return (Category) categoryRepository.findOne(id);
	}
	
	public void addCategory(Category category){
		categoryRepository.save(category);
	}

}
