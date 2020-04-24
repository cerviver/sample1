package com.userboard.dao;

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

}
