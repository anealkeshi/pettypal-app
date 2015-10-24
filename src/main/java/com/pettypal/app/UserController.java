package com.pettypal.app;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pettypal.domain.User;
import com.pettypal.exception.UnableToUploadImageException;
import com.pettypal.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Value("${image.path}")
	private String path;
	
	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	public String register(@ModelAttribute("newUser") User user) {

		return "registration";
	}

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("newUser") User user, BindingResult result,
			HttpServletRequest request, RedirectAttributes redirectAttribute) {

		if (result.hasErrors())
			return "registration";

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}

		User saveduser = userService.save(user);
		MultipartFile userImage = user.getUserImage();

		// isEmpty means file exists BUT NO Content
		if (userImage != null && !userImage.isEmpty()) {
			try {

				userImage.transferTo(new File(path + saveduser.getId() + ".png"));

				LOGGER.info("Image moved succesfully to " + path);

			} catch (Exception e) {
				LOGGER.info(e.getMessage());
				throw new UnableToUploadImageException(null);
			}
		}

		return "redirect:/login";
	}
}
