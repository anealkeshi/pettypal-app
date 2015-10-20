package com.pettypal.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {

	private static final Log logger = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		logger.info("return login form");
 		return "login";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "redirect:/welcome";
 	}
	
//	@RequestMapping(value="/error-forbidden", method = RequestMethod.POST)
//	public String errorPage(Model model) {
//		return "error-forbidden";
// 	}
}
