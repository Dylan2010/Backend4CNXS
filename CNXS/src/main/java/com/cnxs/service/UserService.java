package com.cnxs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cnxs.bo.User;
import com.cnxs.common.UserInfoContextHolder;
import com.cnxs.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
    private UserDao userDao;
	
	@Autowired
	private JWTService jwtSrv;
	
	private BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	public int createUser(User user) {
		user.setPassword( bCryptEncoder.encode(user.getPassword()));
		return userDao.createUser(user);
	}
	
	public User logIn(User user) {
		User targetUser = userDao.findUserByAccount(user);
		if(bCryptEncoder.matches(user.getPassword(), targetUser.getPassword())) {
		    String accessToken = jwtSrv.registerToken(user.getId());
		    UserInfoContextHolder.setUserInfo(user.getId(),accessToken);
			return targetUser;
		}
		return null;
	}
	
	public Boolean logOff() {
	    if(UserInfoContextHolder.getUserinfolocal().get().getJwt() == null) {
	        return false;
	    }
	    return null != jwtSrv.removeToken(UserInfoContextHolder.getUserinfolocal().get().getJwt());
	}
}
