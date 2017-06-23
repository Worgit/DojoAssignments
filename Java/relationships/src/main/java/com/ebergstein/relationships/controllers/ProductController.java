package com.ebergstein.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.relationships.models.Category;
import com.ebergstein.relationships.models.Product;
import com.ebergstein.relationships.services.CategoryService;
import com.ebergstein.relationships.services.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	private CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product){
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(
			@Valid Product product,
			BindingResult result, 
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}else{
			productService.addProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String Product(@PathVariable("id") Long id, Model model){
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.findCategoriesNotInCategoryList(product.getCategories()));
		return "Product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(
			Model model,
			@PathVariable("id") Long id,
			@RequestParam(value="category") Category category) {
		Product product = productService.findProductById(id);
		product.getCategories().add(category);
		productService.addProduct(product);
		return "redirect:/products/" + product.getId();
	}
}
	
