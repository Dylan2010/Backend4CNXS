package com.cnxs.service;

import io.jsonwebtoken.Claims;

public interface JWTService {
    
    public String registerToken(int userId, boolean isKeyUser);
    
    public Claims validateToken(String token);
    
    public Integer removeToken(String token);
    
}
