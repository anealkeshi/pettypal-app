package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.UserPayment;;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

	@Query("select p from user_payment p where p.id = :id")
	public UserPayment get(@Param("id") Long id);
	
	@Query("select p from user_payment p where p.user.id = :user_id")
	public List<UserPayment> getByUserId(@Param("user_id") Long userid);
	
	@Query("select p from user_payment p where p.payment.id = :payment_id")
	public List<UserPayment> getByPaymentId(@Param("payment_id") long paymentid);
}
