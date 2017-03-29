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

public class UserRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //all the get method will be allowed
        if(shouldSkipPermissionControl(request)) {
            filterChain.doFilter(request, response);
        } else{
            String token = request.getHeader(HeaderConstant.X_ACCESS_TOKEN);
            
            JWTService jwtSrv = ApplicationContextHolder.getBean(JWTService.class);
            
            
            
            if(!StringUtils.isEmpty(token) ) {
                int userId = jwtSrv.validateToken(token);
                if(userId != -1) {
                    UserInfoContextHolder.setUserInfo(userId, token);
                    filterChain.doFilter(request, response);
                }
            }
          
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } 
        
    }
    
    private boolean shouldSkipPermissionControl(HttpServletRequest request) {
        return ("GET".equals(request.getMethod()) || !"true".equals(System.getenv("enable.permission.control"))) || 
                (request.getPathInfo().contains("User/v1") && !request.getPathInfo().contains("logoff") );
    }

}
