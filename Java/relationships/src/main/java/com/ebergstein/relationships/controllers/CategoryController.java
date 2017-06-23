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
public class CategoryController {
	private ProductService productService;
	private CategoryService categoryService;
	
	public CategoryController(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category){
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(
			@Valid Category category,
			BindingResult result, 
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}else{
			categoryService.addCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String Product(@PathVariable("id") Long id, Model model){
		Category category = categoryService.findCategoryById(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.findProductsNotInProductList(category.getProducts()));
		return "Category.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProductToCategory(
			@RequestParam(value="product") Product product,
			Model model,
			@PathVariable("id") Long id) {
		Category category = categoryService.findCategoryById(id);
		category.getProducts().add(product);
		categoryService.addCategory(category);
		return "redirect:/categories/" + category.getId();
	}
}
