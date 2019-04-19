package com.dtb.mymoneyappapi.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { EnumValidation.class })
public @interface Enum {
	Class<? extends java.lang.Enum<?>> enumClazz();
	
	String message() default "Invalid Enum.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
