package com.pettypal.custom;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.pettypal.domain.Credential;
import com.pettypal.repository.CredentialRepository;

/**
 * Custom Login implementation
 * 
 * @author Anil
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	private CredentialRepository credentialRepository;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = "";
		if (authentication.getCredentials() != null) {
			password = authentication.getCredentials().toString();
		}
		Credential credential = credentialRepository.getCredentialByUsername(username);

		if (credential != null && credential.getPassword().equals(password)) {
			LOGGER.info("Successfully signed in user: {}", username);
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
		} else {
			LOGGER.error("Invalid username/password combination", username);
			throw new AuthenticationCredentialsNotFoundException("Username or password incorrect");
		}
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}