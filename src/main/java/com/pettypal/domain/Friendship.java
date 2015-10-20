package com.pettypal.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.pettypal.domain.converters.LocalDateConverter;

@Entity(name = "friendship")
public class Friendship extends BaseEntityAudit {

	private static final long serialVersionUID = -8950073132358183472L;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "first_user_id", referencedColumnName = "id")
	private User firstUser;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "second_user_id", referencedColumnName = "id")
	private User secondUser;
	
	@Convert(converter = LocalDateConverter.class)
	private LocalDateTime since;
	
	@Enumerated(EnumType.STRING)
	private FriendshipStatus status;

	public User getFirstUser() {
		return firstUser;
	}

	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}

	public User getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}

	public LocalDateTime getSince() {
		return since;
	}

	public void setSince(LocalDateTime since) {
		this.since = since;
	}

	public FriendshipStatus getStatus() {
		return status;
	}

	public void setStatus(FriendshipStatus status) {
		this.status = status;
	}
	
	
	

}
