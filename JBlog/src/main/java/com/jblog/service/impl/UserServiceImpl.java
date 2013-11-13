package com.jblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.dao.UserMapper;
import com.jblog.domain.User;
import com.jblog.query.UserQuery;
import com.jblog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(UserQuery userQuery) {
		int userCount = userMapper.findUserByName(userQuery.getUserName());
		if (userCount == 1) {
			return userMapper.login(userQuery);
		} else {
			return null;
		}
	}

	@Override
	public Integer findUserByName(String userName) {
		return null;
	}

	@Override
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public boolean updateUserPass(UserQuery userQuery) {
		return userMapper.updateUserPass(userQuery);
	}

	@Override
	public boolean updateUserInfo(User user) {
		return userMapper.updateUserInfo(user);
	}

}
