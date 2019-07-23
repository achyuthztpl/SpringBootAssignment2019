package com.learning.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.demo.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Long>{

	/*
	 * public List<Employee> getEmployees();
	 * 
	 * public Employee getEmployee(Long id);
	 * 
	 * public Employee createEmpoloyee(Employee emp);
	 * 
	 * public Employee updateEmployee(Employee emp, Long id);
	 * 
	 * public Long deleteEmployee(Long id);
	 */
}
