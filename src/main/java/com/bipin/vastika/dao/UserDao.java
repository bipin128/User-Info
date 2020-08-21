package com.bipin.vastika.dao;

import com.bipin.vastika.model.User;

import java.util.List;


public interface UserDao {

	int saveUserInfo(User user);

	int updateUserInfo(User user);

	int deleteUserInfo(int id);

	User getUserById(int id);

	List<User> getAllUser();

}
