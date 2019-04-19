package com.dtb.mymoneyappapi.model.dto;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorsDto {
	private List<String> errors;
	public ErrorsDto(String error) {
		errors = Arrays.asList(error);
	}
	
	public static ErrorsDto error(String error) {
		return new ErrorsDto(error);
	}
	
	public static ErrorsDto exception(RuntimeException e) {
		throw e;
	}
}
