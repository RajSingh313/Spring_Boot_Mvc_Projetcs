package com.raj.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.main.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
