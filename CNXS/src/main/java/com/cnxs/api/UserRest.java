package com.cnxs.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cnxs.bo.User;
import com.cnxs.common.UserInfoContextHolder;
import com.cnxs.constant.HeaderConstant;
import com.cnxs.service.UserService;

@RestController
@RequestMapping(value = { "User/v1" })
public class UserRest {
	
	@Autowired
	private UserService userSrv;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Boolean> createUser(@RequestBody User user) {
		int res = userSrv.createUser(user);
		return res < 0 ?  new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST) : new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<Boolean> login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
		User targetUser = userSrv.logIn(user);
		response.setHeader(HeaderConstant.X_ACCESS_TOKEN, UserInfoContextHolder.getUserinfolocal().get().getJwt());
		return targetUser == null ?  new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST) : new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logoff" , method = RequestMethod.POST)
	public ResponseEntity<Boolean> logooff(HttpServletRequest request, HttpServletResponse response) {
	    Boolean res = userSrv.logOff();
	    return res == false ?  new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST) : new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
