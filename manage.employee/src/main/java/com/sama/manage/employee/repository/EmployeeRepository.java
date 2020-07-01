package com.sama.manage.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sama.manage.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
