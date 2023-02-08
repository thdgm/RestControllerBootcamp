package com.bootcamp.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.bootcamp.services.MessageService;

@RestController
public class MessageRestController {
	 
	@Autowired
	private MessageService msgser;
	
	
	
	
	@GetMapping("/api/v1/{message}")
	 String helloWorld(@RequestParam(value = "name") String name) {
	    return name;
	 }
	
	@GetMapping("/api/v1/message")
	 String helloWorld() {
	    return msgser.getMessage();
	 }
	
}
