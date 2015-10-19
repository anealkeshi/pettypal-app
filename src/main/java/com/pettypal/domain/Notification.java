package com.pettypal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "notification")
public class Notification extends BaseEntityAudit {

	private static final long serialVersionUID = 4206477278367439001L;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User initiator;
	
	@Enumerated(EnumType.STRING)
	private NotificationType type;
	
	@Enumerated(EnumType.STRING)
	private NotificationStatus status;
	
	@OneToOne
	@JoinColumn(name = "payment_id", referencedColumnName = "id")
	private Payment payment;
	
	private String message;

	public User getInitiator() {
		return initiator;
	}

	public void setInitiator(User initiator) {
		this.initiator = initiator;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public NotificationStatus getStatus() {
		return status;
	}

	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((initiator == null) ? 0 : initiator.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (initiator == null) {
			if (other.initiator != null)
				return false;
		} else if (!initiator.equals(other.initiator))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notification [initiator=" + initiator + ", type=" + type + ", status=" + status + ", payment=" + payment
				+ ", message=" + message + "]";
	}	

}
