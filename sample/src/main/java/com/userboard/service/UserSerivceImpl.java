package com.userboard.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userboard.dao.UserDAO;
import com.userboard.dto.User;
import com.userboard.exception.LoginAuthFailException;
import com.userboard.exception.UserExistException;
import com.userboard.exception.UserNotFoundException;

@Service
public class UserSerivceImpl implements UserService{

	@Autowired
	private UserDAO dao;
	
	@Transactional
	@Override
	public void addUser(User user) throws UserExistException {
		
		if(dao.selectUser(user.getUserId())!=null) {
			throw new UserExistException(user, "해당 아이디는 사용중입니다.");
		}
		
		user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt(10)));
		
		dao.insertUser(user);
	}

	@Override
	public User getUser(String userId) throws UserNotFoundException {
		User user  = dao.selectUser(userId);
		
		if(user==null) {
			throw new UserNotFoundException("비정상적인 접근방식 입니다.");
		}
		
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return dao.selectAllUser();
	}
	
	@Override
	public void loginAuth(User user) throws LoginAuthFailException {
		
		User authUser = dao.selectUser(user.getUserId());
		
		if(authUser==null) {
			throw new LoginAuthFailException(user.getUserId(), "비정상적인 접근방식 입니다.");
		}
		
		if(!BCrypt.checkpw(user.getUserPassword(), authUser.getUserPassword())) {
			throw new LoginAuthFailException(user.getUserId(), "비정상적인 접근방식 입니다.");
		}
		
	}
	
	@Transactional
	@Override
	public void modifyUser(User user) throws UserNotFoundException {
		
		System.out.println("userId = "+user.getUserId());
		
		if(dao.selectUser(user.getUserId())==null) {
			throw new UserNotFoundException("비정상적인 접근방식입니다.");
		}
		
		if(user.getUserPassword()!=null && !user.getUserPassword().equals("")) {
			user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt(10)));
		}
		
		dao.updateUser(user);
	}

	@Transactional
	@Override
	public void modifyUserGrade(User user) throws UserNotFoundException {
		if(dao.selectUser(user.getUserId())==null) {
			throw new UserNotFoundException("비정상적인 접근방식입니다.");
		}
		
		dao.updateUserGrade(user);
	}

	@Transactional
	@Override
	public void eraseUser(String userId) throws UserNotFoundException {
		if(dao.selectUser(userId)==null) {
			throw new UserNotFoundException("비정상적인 접근방식입니다.");
		}
		
		dao.deleteUser(userId);
	}

}
