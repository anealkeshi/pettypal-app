package com.pettypal.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pettypal.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	private PaymentService paymentService;
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String request(Model model){
		
		return "paymentRequest";
		
	}
	

}
