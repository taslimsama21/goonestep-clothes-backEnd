package com.sama.manage.employee.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sama.manage.employee.models.Employee;
import com.sama.manage.employee.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/get")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@PostMapping("/add/employee")
	public void createEmployee(@RequestBody Employee employee) throws IOException {
		employeeRepository.save(employee);
	}
	
	@PutMapping("/update/employee")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

	@DeleteMapping(path = { "delete/employee/{id}" })
	public Employee deleteEmployee(@PathVariable("id") long id) {
		Employee employee = employeeRepository.getOne(id);
		employeeRepository.deleteById(id);
		return employee;
	}
}
