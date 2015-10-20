package com.pettypal.app;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PettypalApp {

	@RequestMapping(value = {"/","/welcome"})
	public String welcome() {
		return "welcome";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/showMessage")
	public String getMessage() {
		return "showMessage";
	}

}
