package com.ebergstein.employees.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.employees.models.Employee;
import com.ebergstein.employees.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAll(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee getOne(Long id){
		return (Employee) employeeRepository.findOne(id);
	}
	
	public void addEmployee(Employee employee){
		employeeRepository.save(employee);
	}
	
	public Employee getTop(){
		return (Employee) employeeRepository.findTop1ByOrderByIdDesc();
	}
	
}
