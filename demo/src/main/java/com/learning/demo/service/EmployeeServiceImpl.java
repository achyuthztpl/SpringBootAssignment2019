package com.learning.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.demo.dao.EmployeeDAO;
import com.learning.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO dao;
	
	@Override
	public Iterable<Employee> getEmployees() {
		return dao.findAll();
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> emp = dao.findById(id);

		return emp.orElse(null);
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return dao.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		if(!dao.existsById(emp.getId()))
			throw new IllegalArgumentException();

		return dao.save(emp);
	}

}
