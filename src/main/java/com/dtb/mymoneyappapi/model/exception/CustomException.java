package com.dtb.mymoneyappapi.model.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5292347266150241664L;
	private final String message;
	private final HttpStatus httpStatus;
	public CustomException(HttpStatus httpStatus, String message) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
	@Override
	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
