package com.bootcamp.bootcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository ur;
	
	@Override 
	public void saveUser(User u) {
		ur.save(u);
	}
	
	@Override 
	public User getUser(Integer id) {
		return ur.findById(id).get();
	}
	
	@Override 
	public Boolean deleteUser(Integer id) {
		 ur.deleteById(id);
		 return true;
	}
}
