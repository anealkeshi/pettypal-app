package com.pettypal.app;

import java.security.Principal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pettypal.domain.User;
import com.pettypal.domain.UserPayment;
import com.pettypal.service.UserPaymentService;
import com.pettypal.service.UserService;

@Controller
public class PettypalHome {
	private static final Log logger = LogFactory.getLog(PettypalHome.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserPaymentService userPaymentService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, Principal userPrincipal) {
		// check user logged in
		if (userPrincipal != null) {
			User user = userService.getUserByUsername(userPrincipal.getName());

			List<UserPayment> uPList = userPaymentService.getByUserID(user.getId());

			double shareAmountTotal = 0;
			double payAmountTotal = 0;
			for (UserPayment userPayment : uPList) {
				shareAmountTotal += userPayment.getShareAmount();
				payAmountTotal += userPayment.getPayedAmount();
			}

			model.addAttribute("recievable", payAmountTotal);
			model.addAttribute("payable", shareAmountTotal);
			model.addAttribute("total", shareAmountTotal - payAmountTotal);
		}

		return "welcome";
	}

	// Go for main function

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/showMessage")
	public String getMessage() {
		return "showMessage";
	}

}
