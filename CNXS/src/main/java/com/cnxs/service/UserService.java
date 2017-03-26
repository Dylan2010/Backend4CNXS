package com.cnxs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cnxs.bo.User;
import com.cnxs.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
    private UserDao userDao;
	
	private BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	public int createUser(User user) {
		user.setPassword( bCryptEncoder.encode(user.getPassword()));
		return userDao.createUser(user);
	}
	
	public User logIn(User user) {
		User targetUser = userDao.findUserByAccount(user);
		if(bCryptEncoder.matches(user.getPassword(), targetUser.getPassword())) {
			return targetUser;
		}
		return null;
	}
}
