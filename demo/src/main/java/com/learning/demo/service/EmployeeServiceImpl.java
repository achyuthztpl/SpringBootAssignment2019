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
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = dao.findById(id); 
		
		if(emp.isPresent())
			return emp.get();
		
		return null;
	}

	@Override
	public Employee createEmpoloyee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		if(!dao.existsById(emp.getId()))
			throw new IllegalArgumentException();

		return dao.save(emp);
	}

}
