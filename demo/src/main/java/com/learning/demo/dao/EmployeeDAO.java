package com.learning.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.demo.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Long>{

}
