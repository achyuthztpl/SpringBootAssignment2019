package com.learning.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.model.Employee;
import com.learning.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
 

	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		
		return service.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		Employee emp = service.getEmployee(id);
		
		if (emp == null)
			return new ResponseEntity<String>("No Employee found for given ID", HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<?> createEmployee(@ModelAttribute Employee emp) {

		emp = service.createEmpoloyee(emp);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		
		service.deleteEmployee(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("/employees")
	public ResponseEntity<?> updateEmployee(@ModelAttribute Employee emp) {

		emp = service.updateEmployee(emp);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@ExceptionHandler()
	public ResponseEntity<?> onExceptionHandle(Exception ex){
		if(ex.getClass() == IllegalArgumentException.class)
			return new ResponseEntity<>("Please provide ID", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>("Check the input", HttpStatus.BAD_REQUEST);
	}

}
