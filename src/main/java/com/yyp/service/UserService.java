package com.yyp.service;

import com.yyp.model.User;

public interface UserService {

	User findOne(Integer id);
	User findByName(String userName);
	User findByUserNameNativeQuery(String userName);
	User findByPassword(String password);
	int updateUser(Integer id);
}
