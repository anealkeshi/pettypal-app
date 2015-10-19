package com.pettypal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.PaymentHistory;

@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {

}
