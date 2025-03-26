package com.raj.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raj.main.model.Employee;
import com.raj.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private  static EmployeeRepository empRepository;
	
	@Autowired
	EmployeeServiceImpl( EmployeeRepository empRepository){
		this.empRepository=empRepository;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return  empRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
	return	empRepository.findById(id);
	}

	@Override
	public Optional<Employee> updateEmployee(long id, Employee emp) {
		return empRepository.findById(id).map(existingEmp -> {
		existingEmp.setName(emp.getName())	;
		existingEmp.setEmail(emp.getEmail());
		existingEmp.setDepartment(emp.getDepartment());
		return empRepository.save(existingEmp);
		
		});
	}

	@Override
	public void deleteEmployee(long id) {
		empRepository.deleteById(id);
		
	}

}
