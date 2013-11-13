package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.User;
import com.jblog.query.UserQuery;

public class UserMapperTest extends MapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testGetUserList(){
		List<User> userList = userMapper.getUserList();
		for(User user : userList){
			logger.info(user.toString());
		}
	}
	
	@Test
	public void testFindUserByName(){
		int count = userMapper.findUserByName("admin");
		logger.info("用户名存在:" + count);
		count = userMapper.findUserByName("adaf");
		logger.info("用户名不存在:" + count);
	}
	
	public void testAddUser(){
		User user = new User();
		user.setUserName("XiWenRen");
		user.setUserPass("123456");
		boolean b = userMapper.addUser(user);
		logger.info("注册" + (b ? "成功" : "失败"));
	}
	
	@Test
	public void testUpdateUserPass(){
		UserQuery userQuery = new UserQuery();
		userQuery.setUserName("XiWenRen");
		userQuery.setUserPass("000000");
		boolean b = userMapper.updateUserPass(userQuery);
		logger.info("更新" + (b ? "成功" : "失败"));
		userQuery.setUserPass("123456");
		userMapper.updateUserPass(userQuery);
	}
}
