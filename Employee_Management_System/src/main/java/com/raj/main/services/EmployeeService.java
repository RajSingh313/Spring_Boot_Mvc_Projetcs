package com.raj.main.services;

import java.util.List;
import java.util.Optional;

import com.raj.main.model.Employee;

public interface EmployeeService {
	
	public Employee  createEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Optional<Employee> getEmployeeById(long id);
	public Optional<Employee> updateEmployee(long id, Employee emp);
	public void deleteEmployee(long id);

}
