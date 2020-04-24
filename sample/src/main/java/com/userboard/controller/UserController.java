package com.userboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userboard.dto.User;
import com.userboard.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/signup_add", method = RequestMethod.POST)
	public String signup(@ModelAttribute User user) {
		
		String userId=user.getUserId();
		String userPassword=user.getUserPassword();
		String userName=user.getUserName();
		String userEmail=user.getUserEmail();
		String userAddress=user.getUserAddress();
		String userPhone=user.getUserPhone();
		

		System.out.println("user_id = "+userId);
		System.out.println("user_password = "+userPassword);
		System.out.println("user_name = "+userName);
		System.out.println("user_email = "+userEmail);
		System.out.println("user_address = "+userAddress);
		System.out.println("user_phone = "+userPhone);
		
		userService.addUser(user);
		return "index";
	}
}
