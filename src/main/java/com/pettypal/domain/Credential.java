package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity(name="credential")
public class Credential extends BaseEntityAudit{
	
	
	
	@Size(min=5, max=20, message="{0} size should between {1} and {2}")
	private String userName;
	
	@Size(min=5, max=20, message="{0} size should between {1} and {2}")
	private String password;

	@Column(name = "AUTHORITY", nullable = false)
 	private String authority;
	
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
