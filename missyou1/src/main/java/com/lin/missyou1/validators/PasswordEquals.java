package com.lin.missyou1.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy=PasswordValidators.class)
public @interface PasswordEquals {

	//java的编程模式，关联
	
	String message() default "密码不一致";
	
	//注解规范
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[]  payload() default {};
	
	
	
}
