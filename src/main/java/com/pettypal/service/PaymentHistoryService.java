package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.PaymentHistory;

public interface PaymentHistoryService {
	
	public List<PaymentHistory> getAll();
	
	public void save(PaymentHistory paymenthistory);
	
	public PaymentHistory get(long Id);
	
	public List<PaymentHistory> getByPaymentID(long paymentId);
	
	public List<PaymentHistory> getByUserID(long userId);

}
