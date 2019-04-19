package com.dtb.mymoneyappapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dtb.mymoneyappapi.model.dto.ErrorsDto;
import com.dtb.mymoneyappapi.model.exception.CustomException;

@RestControllerAdvice
public class RestControllerAdviceController {
	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ErrorsDto> handleCustomException(CustomException ex){
		return new ResponseEntity<ErrorsDto>(ErrorsDto.error(ex.getMessage()), ex.getHttpStatus());
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorsDto handleMethoArguentNotValidException(MethodArgumentNotValidException ex){
		List<String> errors = ex.getBindingResult().getAllErrors()
				.stream()
				.map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
		
		return ErrorsDto.builder().errors(errors).build();
	}
}
