package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name = "user_payment")
public class UserPayment extends BaseEntityAudit {

	private static final long serialVersionUID = -6979135832669249512L;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id", referencedColumnName = "id")
	private Payment payment;

	@Column(name = "share_amount")
	private double shareAmount;

	@Column(name = "payed_amount")
	private double payedAmount;

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

	public double getShareAmount() {
		return shareAmount;
	}

	public void setShareAmount(double shareAmount) {
		this.shareAmount = shareAmount;
	}

	public double getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(double payedAmount) {
		this.payedAmount = payedAmount;
	}

	@Transient
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
