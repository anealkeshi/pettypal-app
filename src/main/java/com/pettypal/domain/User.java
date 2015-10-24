package com.pettypal.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.pettypal.custom.PhoneConverter;
import com.pettypal.formatter.PhoneFormat;

@Entity(name = "user")
public class User extends BaseEntityAudit {

	private static final long serialVersionUID = -4200665527938734620L;

	@NotEmpty
	@Size(min=4,max=20, message="{Size.name}")
	private String firstName;

	@NotEmpty
	@Size(min=4,max=20, message="{Size.name}")
	private String lastName;

	@NotNull
	@Convert(converter=PhoneConverter.class)
	@PhoneFormat(message = "{phone.error}")
	private Phone phonenumber;

	@Email
	private String email;
	
	@NotNull
 	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthDate;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_id", referencedColumnName = "id")
	private Credential credential;
	
	@Transient
	private MultipartFile userImage;

	public MultipartFile getUserImage() {
		return userImage;
	}

	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}

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

	public Phone getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Phone phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}
