package com.yyp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyp.dao.UserDao;
import com.yyp.model.User;
import com.yyp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	

	public User findOne(Integer id) {
		return userDao.findOne(id);
	}


	public User findByName(String userName) {
		return userDao.findByNameLike(userName+"%");
	}


	@Override
	public User findByPassword(String password) {
		return userDao.findByPassword(password+"%");
	}


	@Override
	public User findByUserNameNativeQuery(String userName) {
		return userDao.findByUsernameNativeQuery(userName+"%");
	}
	@Override
	public int updateUser(Integer id) {
		System.out.println("dedldl");
		return userDao.UpdateUsesrName(id);
	}

}
