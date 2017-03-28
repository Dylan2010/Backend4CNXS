package com.cnxs.service;

public interface JWTService {
    
    public String registerToken(int userId);
    
    public int validateToken(String token);
    
    public Integer removeToken(String token);
}
