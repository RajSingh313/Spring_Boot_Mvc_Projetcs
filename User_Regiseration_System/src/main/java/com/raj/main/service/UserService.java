package com.raj.main.service;

import com.raj.main.entities.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public User loginUser(String email, String password);

}
