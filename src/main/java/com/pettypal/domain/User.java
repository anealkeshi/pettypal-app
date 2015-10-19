package com.pettypal.domain;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnTransformers;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.pettypal.domain.converters.LocalDateConverter;

@Entity(name="user")
public class User extends BaseEntityAudit {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4200665527938734620L;

	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@Pattern(regexp="^\\d{3}-^\\d{3}-^\\d{4}", message="{0} invalid input format")
	private String phonenumber;
	
	@Email
	private String email;
	
	@Past
	@Convert(converter = LocalDateConverter.class)
	private LocalDateTime birthDate;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	
}
