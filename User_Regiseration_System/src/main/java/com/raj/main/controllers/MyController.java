package com.raj.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.raj.main.entities.User;
import com.raj.main.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	//Controller class used to handle the HTTP Request 
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/regPage")
	public String  openRegPage(Model model) {
		model.addAttribute("user", new User());	
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
	
		boolean status  = userService.registerUser(user);
		if (status) {
			model.addAttribute("successMsg", "user registered successfully");
			
		} else {
			
			model.addAttribute("errorMsg", "user registeration failed due to some error");


		}
		return "register";
		
		
		
		
		
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		
		model.addAttribute("user", new User());
		return "login";
		
	}
	
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		
		if(validUser!=null) {
			
			
			model.addAttribute("modelName", validUser.getName());
			model.addAttribute("modelEmail", validUser.getEmail());
			model.addAttribute("modelPhoneno", validUser.getPhoneno());

			return "profile";
		}
		
		else{
			model.addAttribute("errorMsg", "Email id and password did'nt match");
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest requsest) {
		
		HttpSession session = requsest.getSession();
		if(session!= null) {
			session.invalidate();
		}
		return "redirect:/loginPage";
	}
	
	 @GetMapping("/about")
	    public String about() {
	        return "about";
	    }
	 
	 @GetMapping("/features")
	    public String features() {
	        return "features";
	    }

	    @GetMapping("/contact")
	    public String contact() {
	        return "contact";
	    }
	

}
