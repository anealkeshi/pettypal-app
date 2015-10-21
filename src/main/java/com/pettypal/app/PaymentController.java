package com.pettypal.app;

import java.io.File;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pettypal.domain.Payment;
import com.pettypal.exception.UnableToUploadImageException;
import com.pettypal.service.PaymentService;

@Controller
@RequestMapping("/payment")
@PreAuthorize("isAuthenticated()")
//@SessionAttributes("savedPayment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Value("${image.path}")
	private String path;
	
	@RequestMapping(value = {"","/request"}, method = RequestMethod.GET)
	public String request(@ModelAttribute("newPayment") Payment payment, Principal userPrincipal){
		System.out.println(userPrincipal.getName());
		return "paymentRequest";
		
	}
	
	@RequestMapping(value = {"","/request"}, method = RequestMethod.POST)
	public String processRequest(@Valid @ModelAttribute("newPayment") Payment payment, BindingResult result
			, Principal userPrincipal, RedirectAttributes redirectAttributes, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "paymentRequest";
		}
		else{
			
			Payment savedPayment = paymentService.save(payment);				

			MultipartFile image = payment.getReceiptImage();
			
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			
			if(image != null && !image.isEmpty()){
				try{
					image.transferTo(new File(path + savedPayment.getId()+".png"));
				}
				catch(Exception e){
					throw new UnableToUploadImageException("Image upload failed.");
				}
			}
						
			redirectAttributes.addFlashAttribute("savedPayment", savedPayment);
			
			redirectAttributes.addAttribute("id", savedPayment.getId());
			//return "paymentRequest";
			return "redirect:/payment/share/{id}";
		}
		
	}
	
	
	@RequestMapping(value = "/share/{id}", method = RequestMethod.GET)
	public String paymentDetails(@PathVariable("id") long id, Model model){
		
		System.out.println(id);
		return "/welcome";
	}

}
