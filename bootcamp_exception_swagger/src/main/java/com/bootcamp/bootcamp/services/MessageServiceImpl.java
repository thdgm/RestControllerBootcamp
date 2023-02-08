package com.bootcamp.bootcamp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Value("${course.message}")
	private String msg;
	
	@Override 
	public String getMessage() {
		return msg;
	}
}
