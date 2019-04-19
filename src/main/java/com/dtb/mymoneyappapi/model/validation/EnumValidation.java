package com.dtb.mymoneyappapi.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidation implements ConstraintValidator<Enum, String>{
	private java.lang.Enum[] enumValues;
	@Override
	public void initialize(Enum constraintAnnotation) {
		Class<? extends java.lang.Enum<?>> enumClazz = constraintAnnotation.enumClazz();
		this.enumValues = enumClazz.getEnumConstants();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for(java.lang.Enum e: enumValues) {
			System.out.println(e.toString());
			if(e.toString().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
