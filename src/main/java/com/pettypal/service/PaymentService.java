package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.Payment;

public interface PaymentService {
	
	public List<Payment> getAll();
	
	public Payment save(Payment payment);
	
	public Payment get(long paymentId);

}
