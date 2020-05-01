package com.userboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.userboard.dto.User;
import com.userboard.exception.LoginAuthFailException;
import com.userboard.exception.UserExistException;
import com.userboard.exception.UserNotFoundException;
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
	public String signup(@ModelAttribute User user) throws UserExistException{
		
		userService.addUser(user);
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, HttpSession session, Model model) throws LoginAuthFailException,UserNotFoundException {
		
		if(user.getUserId().equals("")) {
			model.addAttribute("message", "아이디를 입력하세요");
			return "login";
		}
		
		if(user.getUserPassword().equals("")) {
			model.addAttribute("message", "비밀번호를 입력하세요");
			return "login";
		}
		
		if(!user.getUserId().equals(user.getUserId())) {
			model.addAttribute("message", "아이디와 아이디가 안맞을경우 컨트롤러");
			return "login";
		}
		
		if(!user.getUserPassword().equals(user.getUserPassword())) {
			model.addAttribute("message", "비번 비번 안맞음 컨트롤러");
			return "login";
		}
		
		userService.loginAuth(user);
		
		session.setAttribute("loginUser", userService.getUser(user.getUserId()));
		
		if(session.getAttribute("destURI")!=null) {
			String destURI = (String)session.getAttribute("destURI");
			session.removeAttribute("destURI");
			return "redirect:"+destURI;
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(@RequestParam String userId, Model model, HttpSession session) throws UserNotFoundException {
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(!loginUser.getUserId().equals(userId)) {
			throw new UserNotFoundException("유저정보가 일치하지 않습니다.");
		}
		
		model.addAttribute("userinfo", userService.getUser(userId));
		
		return "mypage";
	}
	
	@RequestMapping(value = "/mypage_modify", method = RequestMethod.POST)
	public String mypageModify(@ModelAttribute User user, HttpSession session) throws UserNotFoundException {
		
		userService.modifyUser(user);
		
		session.setAttribute("loginUser", userService.getUser(user.getUserId()));
		
		return "redirect:/mypage?userId="+user.getUserId();
	}
	
	@RequestMapping(value = "/remove_user", method = RequestMethod.POST)
	public String removeUser(@RequestParam String userId,HttpSession session) throws UserNotFoundException{
		if(userId.equals("admin")) {
			throw new UserNotFoundException("관리자 아이디 입니다");
		}
		
		userService.eraseUser(userId);
		
		session.invalidate();
		
		return "index";
	}
	
	@RequestMapping(value = "/allUser")
	public String allUser(Model model, HttpSession session, HttpServletRequest request) throws UserNotFoundException {
		
		model.addAttribute("userList", userService.getAllUser());
		
		return "allUser";
	}
	
	@RequestMapping(value = "/view")
	public String view(@RequestParam String userId, Model model) throws UserNotFoundException {

		model.addAttribute("userinfo", userService.getUser(userId));
		
		return "view";
	}
}
