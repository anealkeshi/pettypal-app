package com.pettypal.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity(name = "payment")
public class Payment extends BaseEntityAudit {

	private static final long serialVersionUID = -2661354058637682676L;
	
	@NotEmpty
	private String description;	
	
	private double totalAmount;
	private double tax;
	private double tip;
	
	private User initiator;
	
	private int numberOfFriends;
	
	@Transient
	private MultipartFile receiptImage;

	@OneToMany(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	private List<UserPayment> userPayments;

	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	//@Convert(converter = LocalDateConverter.class)
	private Date paymentDate;

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

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public User getInitiator() {
		return initiator;
	}

	public void setInitiator(User initiator) {
		this.initiator = initiator;
	}

	public List<UserPayment> getUserPayments() {
		return userPayments;
	}

	public void setUserPayments(List<UserPayment> userPayments) {
		this.userPayments = userPayments;
	}

	public int getNumberOfFriends() {
		return numberOfFriends;
	}

	public void setNumberOfFriends(int numberOfFriends) {
		this.numberOfFriends = numberOfFriends;
	}

	public MultipartFile getReceiptImage() {
		return receiptImage;
	}

	public void setReceiptImage(MultipartFile recieptImage) {
		this.receiptImage = recieptImage;
	}

}
