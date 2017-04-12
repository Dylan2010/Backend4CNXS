package com.cnxs.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cnxs.common.ApplicationContextHolder;
import com.cnxs.common.UserInfoContextHolder;
import com.cnxs.constant.HeaderConstant;
import com.cnxs.service.JWTService;

import io.jsonwebtoken.Claims;

public class UserRequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// all the get method will be allowed
		String token = request.getHeader(HeaderConstant.X_ACCESS_TOKEN);

		JWTService jwtSrv = ApplicationContextHolder.getBean(JWTService.class);

		Boolean isKeyUser = false;

		if (!StringUtils.isEmpty(token)) {

			Claims claims = jwtSrv.validateToken(token);

			isKeyUser = claims != null ? claims.get("isKeyUser", Boolean.class) : false;

			Integer userId = claims != null ? claims.get("userId", Integer.class) : -1;

			UserInfoContextHolder.setUserInfo(userId, isKeyUser, token);
		}
		if (shouldSkipPermissionControl(request)) {
			filterChain.doFilter(request, response);

		} else {
			if (isKeyUser) {
				filterChain.doFilter(request, response);
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}

	}

	private boolean shouldSkipPermissionControl(HttpServletRequest request) {
		return ("GET".equals(request.getMethod()) || !"true".equals(System.getenv("enable.permission.control")))
				|| (request.getPathInfo().contains("User/v1") && !request.getPathInfo().contains("logoff")
						&& !request.getPathInfo().contains("id"));
	}

}
