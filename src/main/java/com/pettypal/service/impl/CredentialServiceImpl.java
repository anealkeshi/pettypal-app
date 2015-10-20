package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Credential;
import com.pettypal.repository.CredentialRepository;
import com.pettypal.service.CredentialService;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	CredentialRepository credentialRepository;

	public void save(Credential credential) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(credential.getPassword());
  		credential.setPassword(encodedPassword);
  		
  		credentialRepository.save(credential);
	}

	public List<Credential> findAll() {
		// TODO Auto-generated method stub
		return (List<Credential>) credentialRepository.findAll();
	}

	
	
	

}
