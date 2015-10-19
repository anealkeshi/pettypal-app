package com.pettypal.domain;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;

import com.pettypal.domain.converters.LocalDateConverter;

@Entity(name = "payment")
public class Payment extends BaseEntityAudit {

	private static final long serialVersionUID = -2661354058637682676L;
	private String description;
	private double totalAmount;
	private double tax;
	private double tip;

	@Convert(converter = LocalDateConverter.class)
	private LocalDateTime payment_date;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}

	public LocalDateTime getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDateTime payment_date) {
		this.payment_date = payment_date;
	}


}
