package com.pettypal.app;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pettypal.custom.NoSuchUserException;
import com.pettypal.domain.Payment;
import com.pettypal.domain.User;
import com.pettypal.domain.UserPayment;
import com.pettypal.service.PaymentService;
import com.pettypal.service.UserService;

@Controller
@RequestMapping("/payment")
@PreAuthorize("isAuthenticated()")
@SessionAttributes("payment")
public class PaymentController {

	@Autowired
	private UserService userService;

	private PaymentService paymentService;

	@RequestMapping(value = { "", "/request" }, method = RequestMethod.GET)
	public String request(@ModelAttribute("newPayment") Payment payment, Principal userPrincipal) {
		System.out.println(userPrincipal.getName());
		return "paymentRequest";

	}

	@RequestMapping(value = { "", "/request" }, method = RequestMethod.POST)
	public String processRequest(@Valid @ModelAttribute("newPayment") Payment payment, BindingResult result,
			Model model, Principal userPrincipal, RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "paymentRequest";
		} else {

			Payment savedPayment = paymentService.save(payment);

			MultipartFile image = payment.getReceiptImage();

			String rootDirectory = request.getSession().getServletContext().getRealPath("/");

			if (image != null && !image.isEmpty()) {
				try {
					image.transferTo(new File(rootDirectory + "\\resources\\images\\" + savedPayment.getId() + ".png"));
				} catch (Exception e) {
					throw new RuntimeException("Image upload failed", e);
				}
			}

			redirectAttributes.addFlashAttribute("savedPayment", savedPayment);
			model.addAttribute("payment", savedPayment);
			redirectAttributes.addAttribute("id", savedPayment.getId());
			// return "paymentRequest";
			return "redirect:/payment/share/";
		}

	}

	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String getShareFrom(@ModelAttribute("payment") Payment payment, Model model, Principal userPrincipal) {

		List<UserPayment> userPayments = new ArrayList<UserPayment>();
		UserPayment userPayment = new UserPayment();
		System.out.println(userPrincipal.getName());
		userPayment.setUser(userService.getUserByUsername(userPrincipal.getName()));
		userPayment.setName("Your Share");
		userPayment.setShareAmount(payment.getTotalAmount());
		userPayments.add(userPayment);
		for (int i = 0; i < payment.getNumberOfFriends(); i++) {
			userPayment = new UserPayment();
			userPayments.add(userPayment);
		}

		payment.setUserPayments(userPayments);
		model.addAttribute("payment", payment);
		return "sharePayment";
	}

	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public String addUserPayment(@ModelAttribute("payment") Payment payment, Model model, Principal userPrincipal) {

		return "redirect:/payment/request";

	}

	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@RequestParam("email") String email) throws NoSuchUserException {
		return userService.getUserByEmail(email);
	}

}
