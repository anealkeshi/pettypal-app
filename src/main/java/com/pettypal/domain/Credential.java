package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity(name = "credential")
public class Credential extends BaseEntityAudit {

	private static final long serialVersionUID = 2224529120903442281L;

	@Size(min = 5, max = 20, message = "{0} size should between {1} and {2}")
	private String userName;

	@Size(min = 5, max = 20, message = "{0} size should between {1} and {2}")
	private String password;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
