package com.bootcamp.bootcamp.controllers;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bootcamp.bootcamp.exceptions.DefaultExceptionObject;

@ControllerAdvice
public class ExceptionHandlerUserController extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })

	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

	String bodyOfResponse = "Error: "+ex.getMessage();

	return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);

	}
	
	@ExceptionHandler(value = { Exception.class})
	public ResponseEntity<DefaultExceptionObject> handleAnyOtherException(Exception ex) {

		DefaultExceptionObject response = new DefaultExceptionObject();
		
		response.setType(ex.getClass().getName());
		response.setTitle("Unexpected error");
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setDetail("An unexpected error ocurred");
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
    

}
