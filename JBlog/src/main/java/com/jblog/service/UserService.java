package com.jblog.service;

import com.jblog.domain.User;
import com.jblog.query.UserQuery;

public interface UserService {
	
	//登陆
	User login(UserQuery userQuery);
	
	//查看用户名是否存在
	Integer findUserByName(String userName);

	//添加用户(注册)
	boolean addUser(User user);
	
	//更改密码
	boolean updateUserPass(UserQuery userQuery);
	
	//更新个人信息
	boolean updateUserInfo(User user);

}
