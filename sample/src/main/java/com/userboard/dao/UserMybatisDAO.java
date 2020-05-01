package com.userboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userboard.dto.User;
import com.userboard.mapper.UserMapper;

@Repository
public class UserMybatisDAO implements UserDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertUser(User user) {
		return sqlSession.getMapper(UserMapper.class).insertUser(user);
	}

	@Override
	public User selectUser(String userId) {
		return sqlSession.getMapper(UserMapper.class).selectUser(userId);
	}

	@Override
	public List<User> selectAllUser() {
		return sqlSession.getMapper(UserMapper.class).selectAllUser();
	}

	@Override
	public int updateUser(User user) {
		return sqlSession.getMapper(UserMapper.class).updateUser(user);
	}

	@Override
	public int deleteUser(String userId) {
		return sqlSession.getMapper(UserMapper.class).deleteUser(userId);
	}

	@Override
	public int updateUserGrade(User user) {
		return sqlSession.getMapper(UserMapper.class).updateUserGrade(user);
	}

}
