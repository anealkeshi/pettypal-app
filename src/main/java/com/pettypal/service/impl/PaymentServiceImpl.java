package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Payment;
import com.pettypal.repository.PaymentRepository;
import com.pettypal.service.PaymentService;

//@Service
//@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepo;
	
	public List<Payment> getAll() {
		return (List<Payment>) paymentRepo.findAll();
	}

	public void save(Payment payment) {
		paymentRepo.save(payment);
		
	}

//	public Payment get(long paymentId) {
//		return paymentRepo.getPaymentById(paymentId);
//	}

}
