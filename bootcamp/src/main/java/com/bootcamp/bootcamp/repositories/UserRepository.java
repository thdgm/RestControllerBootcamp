package com.bootcamp.bootcamp.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.bootcamp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	void deleteById(Integer id);
	

}
