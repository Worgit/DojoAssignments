package com.ebergstein.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.relationships.models.Category;
import com.ebergstein.relationships.models.Product;
import com.ebergstein.relationships.repositories.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	public List<Product> findProductsNotInProductList(List<Product> products){
		List<Product> all = (List<Product>) productRepository.findAll();
		//System.out.println(all.size());
		for(int i = 0; i < all.size(); i++){
			if(products.contains(all.get(i))){
				all.remove(i);
				i--;
			}
		}
		//System.out.println(all.size());
		return all;
	}
	
	public Product findProductById(long id){
		return (Product) productRepository.findOne(id);
	}
	
	public void addProduct(Product product){
		productRepository.save(product);
	}

}
