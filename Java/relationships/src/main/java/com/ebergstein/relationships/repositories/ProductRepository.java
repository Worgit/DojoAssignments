package com.ebergstein.relationships.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.relationships.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	//List<Product> sortByNotIn(List<Product> products);
	
}
