package com.pettypal.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Payment;
import com.pettypal.domain.User;
import com.pettypal.domain.UserPayment;
import com.pettypal.repository.UserPaymentRepository;
import com.pettypal.service.UserPaymentService;

@Service
@Transactional
public class UserPaymentServiceImpl implements UserPaymentService {

	@Autowired
	private UserPaymentRepository userpaymentRepository;

	@PersistenceContext
	private EntityManager em;

	public List<UserPayment> getAll() {
		return (List<UserPayment>) userpaymentRepository.findAll();
	}

	public void save(UserPayment payment) {
		User user = em.find(User.class, payment.getUser().getId());
		payment.setUser(user);
		
		Payment paymnt = em.find(Payment.class,  payment.getPayment().getId());
		payment.setPayment(paymnt);
		
		userpaymentRepository.save(payment);

	}

	public List<UserPayment> getByPaymentID(long paymentId) {
		return userpaymentRepository.getByPaymentId(paymentId);
	}

	public List<UserPayment> getByUserID(long userId) {
		return userpaymentRepository.getByUserId(userId);
	}

	public UserPayment get(long Id) {
		return userpaymentRepository.get(Id);
	}

}
