package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.PaymentHistory;
import com.pettypal.repository.PaymentHistoryRepository;
import com.pettypal.service.PaymentHistoryService;

@Service
@Transactional
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

	@Autowired
	PaymentHistoryRepository paymentHistoryRepository;
	
	public List<PaymentHistory> getAll() {
		return (List<PaymentHistory>) paymentHistoryRepository.findAll();
	}

	public void save(PaymentHistory payment) {
		paymentHistoryRepository.save(payment);
		
	}

	public List<PaymentHistory> getByPaymentID(long paymentId) {
		return paymentHistoryRepository.getByPaymentId(paymentId);
	}

	public List<PaymentHistory> getByUserID(long userId) {
		return paymentHistoryRepository.getByUserId(userId);
	}

	public PaymentHistory get(long Id) {
		return paymentHistoryRepository.get(Id);
	}

}
