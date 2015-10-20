package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.Credential;

public interface CredentialService {

	public void save(Credential credential);
	public List<Credential> findAll();

}
