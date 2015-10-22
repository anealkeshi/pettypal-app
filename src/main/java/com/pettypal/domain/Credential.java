package com.pettypal.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity(name = "credential")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "username" }) )
public class Credential extends BaseEntityAudit {

	private static final long serialVersionUID = 2224529120903442281L;

	@Size(min = 5, max = 20, message = "{Size.name}")
	private String username;

	@Size(min = 5, max = 20, message = "{Size.name}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
