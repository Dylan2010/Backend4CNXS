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
	
	//加密
	private BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
	
	//创建用户
	public int createUser(User user) {
		user.setPassword( bCryptEncoder.encode(user.getPassword()));
		return userDao.createUser(user);
	}
	
	//更新用户
	public boolean updateUser(User user, Integer id) {
	    if(user == null || user.getId() != id || id < 0) {
	        return false;
	    } else {
	    	user.setPassword( bCryptEncoder.encode(user.getPassword()));
	        return userDao.updateUser(user);
	    }
	}
	
	//登录
	public User logIn(User user) {
		User targetUser = userDao.findUserByAccount(user);
		if(targetUser != null && bCryptEncoder.matches(user.getPassword(), targetUser.getPassword())) {
		    String accessToken = jwtSrv.registerToken(targetUser.getId(), targetUser.isKeyUser());
		    UserInfoContextHolder.setUserInfo(targetUser.getId(),targetUser.isKeyUser(),accessToken);
			return targetUser;
		}
		return null;
	}
	
	//登出
	public Boolean logOff() {
	    if(UserInfoContextHolder.getUserinfolocal().get().getJwt() == null) {
	        return false;
	    }
	    return null != jwtSrv.removeToken(UserInfoContextHolder.getUserinfolocal().get().getJwt());
	}
}
