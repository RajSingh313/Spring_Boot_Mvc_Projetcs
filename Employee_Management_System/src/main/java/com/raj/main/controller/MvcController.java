package com.raj.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raj.main.model.Employee;
import com.raj.main.services.EmployeeService;


@Controller
@RequestMapping("/employees")
public class MvcController {
	
	@Autowired
	private  EmployeeService empService;
	
	@GetMapping
	public String  getAllEmployees(Model  model) {
	List<Employee> employee=	empService.getAllEmployees();
	model.addAttribute("employees" , employee);
	return "employee-list";
		
	}
	
	
	 @GetMapping("/new")
	    public String showEmployeeForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "employee-form";  // Returns form view for adding employees
	    }
	 

	    @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute Employee employee) {
	        empService.createEmployee(employee);
	        return "redirect:/employees";  // Redirects to employee list
	    }
	    
	    
	    @GetMapping("/edit/{id}")
	    public String editEmployee(@PathVariable Long id, Model model) {
	       Optional<Employee> employee = empService.getEmployeeById(id);
	        model.addAttribute("employee", employee);
	        return "employee-form";  // Returns the same form for editing
	    }
	
	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        empService.deleteEmployee(id);
	        return "redirect:/employees";
	    }

}
