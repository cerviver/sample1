package com.userboard.mapper;

import java.util.List;

import com.userboard.dto.User;

public interface UserMapper {
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(String userId);
	//유저 등급 변경
	int updateUserGrade(User user);
	
	User selectUser(String userId);
	List<User> selectAllUser();
}
