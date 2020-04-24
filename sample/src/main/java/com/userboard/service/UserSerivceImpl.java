package com.userboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userboard.dao.UserDAO;
import com.userboard.dto.User;

@Service
public class UserSerivceImpl implements UserService{

	@Autowired
	private UserDAO dao;
	
	@Transactional
	@Override
	public void addUser(User user) {
		
		dao.insertUser(user);
	}

}
