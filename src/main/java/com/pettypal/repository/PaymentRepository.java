package com.pettypal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
	
	@Query("select p from payment p where p.id = :id")
	Payment getPaymentById(@Param("id") long id);

}
