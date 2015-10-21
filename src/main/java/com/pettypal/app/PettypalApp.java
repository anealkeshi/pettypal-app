package com.pettypal.app;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pettypal.domain.User;
import com.pettypal.service.UserService;

@Controller
public class PettypalApp {
	private static final Log logger = LogFactory.getLog(PettypalApp.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"/","/welcome"})
	public String welcome() {
		logger.info("welcome page shown");
		return "welcome";
	}
	
	
	//Go for main function
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/showMessage")
	public String getMessage() {
		return "showMessage";
	}
	
	
	@RequestMapping(value = "/Registration", method= RequestMethod.GET)
	public String register(@ModelAttribute("newUser") User user) {
		
		return "addUser";
	}
	
	@RequestMapping(value = "/Registration", method= RequestMethod.POST)
	public String SaveUser(@Valid @ModelAttribute("newUser") User user) {
		
		userService.save(user);
		return "redirect:/welcome";
	}

}
