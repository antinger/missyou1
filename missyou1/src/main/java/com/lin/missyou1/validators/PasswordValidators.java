package com.lin.missyou1.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lin.missyou1.dto.PersonDto;

public class PasswordValidators implements ConstraintValidator<PasswordEquals, PersonDto> {

	@Override
	public void initialize(PasswordEquals constraintAnnotation) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(PersonDto personDto, ConstraintValidatorContext context) {
		
		return false;
	}

	//第二个参数:自定义注解修饰的目标类型
	
}
