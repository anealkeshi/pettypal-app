package com.pettypal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.Credential;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Long> {

}