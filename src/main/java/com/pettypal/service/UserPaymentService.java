package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.UserPayment;

public interface UserPaymentService {
	
	public List<UserPayment> getAll();
	
	public void save(UserPayment userpayment);
	
//	public UserPayment getByPaymentID(long paymentId);
//	
//	public UserPayment getByUserID(long userId);

}
