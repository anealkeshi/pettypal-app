package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity(name="credential")
public class Credential extends BaseEntityAudit{
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	@Size(min=5, max=20, message="{0} size should between {1} and {2}")
	private String userName;
	
	@Size(min=5, max=20, message="{0} size should between {1} and {2}")
	private String password;
	

}
