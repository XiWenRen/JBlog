package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.User;

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

}
