package com.userboard.service;

import java.util.List;

import com.userboard.dto.User;
import com.userboard.exception.LoginAuthFailException;
import com.userboard.exception.UserExistException;
import com.userboard.exception.UserNotFoundException;

public interface UserService {
	void addUser(User user) throws UserExistException;
	void modifyUser(User user) throws UserNotFoundException;
	void modifyUserGrade(User user) throws UserNotFoundException;
	void eraseUser(String userId) throws UserNotFoundException;
	
	User getUser(String userId) throws UserNotFoundException;
	List<User> getAllUser();
	
	void loginAuth(User user) throws LoginAuthFailException;
	
}
