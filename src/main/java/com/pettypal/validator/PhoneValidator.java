package com.pettypal.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pettypal.formatter.PhoneFormat;
import com.pettypal.domain.Phone;

public class PhoneValidator implements ConstraintValidator<PhoneFormat, Phone> {

	public void initialize(PhoneFormat constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(Phone phoneNumber, ConstraintValidatorContext context) {
		
		return true;
	}

}
