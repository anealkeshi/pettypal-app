package com.pettypal.formatter;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;

import com.pettypal.validator.PhoneValidator;

@Documented
@Constraint(validatedBy = { PhoneValidator.class })
@Target({ ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@NotNull
public @interface PhoneFormat {

	String message()

	default "{phone.error}";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};
}
