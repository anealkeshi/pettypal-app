package com.pettypal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.UserPayment;;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

	@Query("select p from payment p where p.id = :id")
	public UserPayment getByUserId(@Param("id") long id);
	
	@Query("select p from payment p where p.id = :id")
	public UserPayment getByPaymentId(@Param("id") long id);
}
