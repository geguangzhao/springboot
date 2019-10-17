package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		return userDao.queryUserList(user);
	}

}
