package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.UserPayment;
import com.pettypal.repository.UserPaymentRepository;
import com.pettypal.service.UserPaymentService;

@Service
@Transactional
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	UserPaymentRepository userpaymentRepo;
	
	public List<UserPayment> getAll() {
		return (List<UserPayment>) userpaymentRepo.findAll();
	}

	public void save(UserPayment payment) {
		userpaymentRepo.save(payment);
		
	}

//	public UserPayment getByPaymentID(long paymentId) {
//		return userpaymentRepo.getByPaymentId(paymentId);
//	}
//
//	public UserPayment getByUserID(long userId) {
//		return userpaymentRepo.getByUserId(userId);
//	}

}
