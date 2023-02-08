package com.bootcamp.bootcamp.services;

import org.springframework.stereotype.Service;

import com.bootcamp.bootcamp.model.User;


public interface UserService {
	
	void saveUser(User u);
	
	User getUser(Integer id);
	
	Boolean deleteUser(Integer id);
}
