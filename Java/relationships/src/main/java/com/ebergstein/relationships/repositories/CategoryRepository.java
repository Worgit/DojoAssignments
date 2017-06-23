package com.ebergstein.relationships.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.relationships.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	//List<Category> sortByNotIn(List<Category> categories);

}
