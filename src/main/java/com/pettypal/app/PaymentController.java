package com.pettypal.app;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pettypal.domain.Payment;
import com.pettypal.service.PaymentService;

@Controller
@RequestMapping("/payment")
@PreAuthorize("isAuthenticated()")
public class PaymentController {
	
	private PaymentService paymentService;
	
	@RequestMapping(value = {"","/request"}, method = RequestMethod.GET)
	public String request(@ModelAttribute("newPayment") Payment payment, Principal userPrincipal){
		System.out.println(userPrincipal.getName());
		return "paymentRequest";
		
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String processRequest(@Valid @ModelAttribute("newPayment") Payment payment, BindingResult result, Principal userPrincipal){
		
		if(result.hasErrors()){
			return "paymentRequest";
		}
		else{
			
			
			return "requestSent";
		}
		
	}

}
