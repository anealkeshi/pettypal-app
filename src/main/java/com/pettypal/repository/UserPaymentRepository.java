package com.pettypal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.UserPayment;;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
