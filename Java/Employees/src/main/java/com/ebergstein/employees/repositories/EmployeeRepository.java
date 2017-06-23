package com.ebergstein.employees.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.employees.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	Employee findTop1ByOrderByIdDesc();

}
