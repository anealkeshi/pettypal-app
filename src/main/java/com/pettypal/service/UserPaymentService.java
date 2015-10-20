package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.UserPayment;

public interface UserPaymentService {
	
	public List<UserPayment> getAll();
	
	public void save(UserPayment userpayment);
	
	public UserPayment get(long Id);
	
	public List<UserPayment> getByPaymentID(long paymentId);
	
	public List<UserPayment> getByUserID(long userId);

}
