package com.example.dao;

import java.util.List;

import com.example.bean.User;

public interface UserDao {

	public List<User> queryUserList(User user);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	User findUser(User user);
}
