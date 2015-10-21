package com.pettypal.app;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pettypal.domain.Friendship;
import com.pettypal.service.FriendshipService;
import com.pettypal.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	FriendshipService friendService;
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	
	@RequestMapping(value={"","/friends"}, method= RequestMethod.GET)
	public String getFriends(Model model)
	{
		model.addAttribute("friendlist", userService.getAllUsers());
		
		return "friendlist";
	}
	@RequestMapping(value="/addfriend", method= RequestMethod.GET)
	public String addFriend(@ModelAttribute("friendship") Friendship friendship)
	{
		
		return "addfriend";
	}
	
	@RequestMapping(value="/addfriend", method= RequestMethod.POST)
	public String sendFriendRequest(@Valid @ModelAttribute("friendship") Friendship friendship)
	{
		friendService.save(friendship);
		return "redirect:/user";
	}
}
