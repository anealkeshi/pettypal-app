package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;

@Entity(name="payment_history")
public class PaymentHistory extends BaseEntityAudit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7166895796187552326L;

	@OneToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;

	@OneToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="payment_id", referencedColumnName = "id")
	private Payment payment;
	
	@Digits(integer=15,fraction=2)
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentType type;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}
	
	
	
}
