package com.ebergstein.employees.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebergstein.employees.models.Employee;
import com.ebergstein.employees.services.EmployeeService;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/")
	public String welcome(@ModelAttribute("employee") Employee employee){
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String newEmployee(@Valid @ModelAttribute("employee") Employee employee,
            BindingResult result){
		if (result.hasErrors()) {
			return "Question.jsp";
		}else{
			employeeService.addEmployee(employee);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/employee/{id}")
	public String welcome(@ModelAttribute("employee") Employee employee, @PathVariable("id") Long id, Model model){
		model.addAttribute("manager", employeeService.getOne(id));
		return "employee.jsp";
	}
	
	@PostMapping("/employee/{id}")
	public String newManager(@Valid @ModelAttribute("employee") Employee employee,
            BindingResult result, Model model, @PathVariable("id") Long id){
		Employee manager = employeeService.getOne(id);
		if (result.hasErrors()) {
			model.addAttribute("manager",manager);
			return "employee.jsp";
		}else{
			Employee top = employeeService.getTop();
			employee.setManager(manager);
			employee.setId(top.getId() + 1);
			//System.out.println(employee.getId());
			//System.out.println(manager.getId());
			employeeService.addEmployee(employee);
			employeeService.addEmployee(manager);
			model.addAttribute("manager",manager);
			return "redirect:/employee/" + id;
		}
	}

}
