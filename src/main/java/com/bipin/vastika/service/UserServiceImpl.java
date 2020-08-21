package com.bipin.vastika.service;

import java.util.List;

import com.bipin.vastika.dao.UserDao;
import com.bipin.vastika.dao.UserDaoImpl;
import com.bipin.vastika.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public int saveUserInfo(User user) {
		return userDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return userDao.deleteUserInfo(id);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
