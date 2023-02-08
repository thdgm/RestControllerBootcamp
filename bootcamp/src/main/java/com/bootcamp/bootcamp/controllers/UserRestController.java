package com.bootcamp.bootcamp.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.bootcamp.model.User;
import com.bootcamp.bootcamp.services.MessageService;
import com.bootcamp.bootcamp.services.UserService;

@RestController
public class UserRestController {
	 
	@Autowired
	private UserService us;
	
	
	
	
	@GetMapping("/users/{id}")
	 User getUserById(@PathVariable(value = "id") Integer id) {
	    return us.getUser(id);
	 }
	
	
	@PostMapping(path ="/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		User u = newUser;
	    us.saveUser(u);
	    return new ResponseEntity<>(u, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateuser(@PathVariable Integer id,@RequestBody User updateuser) {
	    User u = us.getUser(id);
	    u.setName(updateuser.getName());
	    us.saveUser(u);
	    return ResponseEntity.ok(u);
	 }
	
	@DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Integer id) {

        var deleted = us.deleteUser(id);

        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
