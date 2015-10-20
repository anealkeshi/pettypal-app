package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.PaymentHistory;

@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {

	@Query("select p from payment_history p where p.id = :id")
	public PaymentHistory get(@Param("id") Long id);
	
	@Query("select p from payment_history p where p.user.id = :user_id")
	public List<PaymentHistory> getByUserId(@Param("user_id") Long userid);
	
	@Query("select p from payment_history p where p.payment.id = :payment_id")
	public List<PaymentHistory> getByPaymentId(@Param("payment_id") long paymentid);
	
}
