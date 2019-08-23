package com.learning.demo.service;


import com.learning.demo.model.Employee;

public interface EmployeeService {

	public Iterable<Employee> getEmployees();

	public Employee getEmployee(Long id);

	public Employee createEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployee(Long id);
}
