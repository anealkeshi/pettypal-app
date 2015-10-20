package com.pettypal.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PettypalApp {
	private static final Log logger = LogFactory.getLog(PettypalApp.class);
	
	@RequestMapping(value = {"/","/welcome"})
	public String welcome() {
		logger.info("welcome page shown");
		return "welcome";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/showMessage")
	public String getMessage() {
		return "showMessage";
	}

}
