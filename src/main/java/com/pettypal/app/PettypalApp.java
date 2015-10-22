package com.pettypal.app;

import java.io.File;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pettypal.domain.User;
import com.pettypal.service.NotificationService;
import com.pettypal.service.PaymentService;
import com.pettypal.service.UserService;

import com.pettypal.exception.UnableToUploadImageException;

@Controller
public class PettypalApp {
	private static final Log logger = LogFactory.getLog(PettypalApp.class);
	
	@Value("${image.path}")
	private String path;
	
	@Autowired
	UserService userService;
	@Autowired
	NotificationService notificationService;
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value = {"/","/welcome"}, method=RequestMethod.GET)
	public String welcome(Model model,Principal userPrincipal) {
		//check user logged in
		if(userPrincipal!=null)
		{
			User user = userService.getUserByUsername(userPrincipal.getName());
			model.addAttribute("notificationList", notificationService.getNotificationListByUser(user.getId()));
			model.addAttribute("payments");
		}
		
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
		
		return "registration";
	}
	
	@RequestMapping(value = "/Registration", method= RequestMethod.POST)
	public String SaveUser(@Valid @ModelAttribute("newUser") User user, BindingResult result , HttpServletRequest request, RedirectAttributes redirectAttribute) {

		
		if(result.hasErrors()) return "registration";
		
		 String[] suppressedFields = result.getSuppressedFields();
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		 
		User saveduser = userService.save(user);
		
		MultipartFile userImage = user.getUserImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			
		//isEmpty means file exists BUT NO Content
			if (userImage!=null && !userImage.isEmpty()) {
		       try {
		    	   
		    	   
		    	   userImage.transferTo(new File(path+ saveduser.getId() + ".png"));
		      
		      	logger.info("Image moved succesfully to " + path);
		      	
		       } catch (Exception e) {
		    	   logger.info(e.getMessage());
				throw new UnableToUploadImageException(null);
		   }
		   }
			
		//redirectAttribute.addFlashAttribute("savedUser",saveduser);
		return "redirect:/login";
	}

}
