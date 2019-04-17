package com.dtb.mymoneyappapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class RestControllerAdviceController {
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex){
		return new ResponseEntity<String>(ex.getMessage(), ex.getStatus());
	}
}
