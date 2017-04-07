package com.cnxs.service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.cnxs.common.UserInfoContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTServiceImpl implements JWTService{
    
    private ConcurrentHashMap<String, Integer> tokens = new ConcurrentHashMap<String, Integer>();
    
    private static long EXPIRATION_DURATION = 24*60*60*1000;
    
    private static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    @Override
    public String registerToken(int userId, boolean isKeyUser) {
        Long expirationTime = System.currentTimeMillis() + EXPIRATION_DURATION;
        String token =  Jwts.builder().setSubject("cnxs_token").claim("userId",
                userId).claim("isKeyUser", isKeyUser)
                 .setExpiration(new Date(expirationTime))
                .signWith(SIGNATURE_ALGORITHM,       
                      getSecretKey()).compact();
        tokens.put(token, userId);
        return token;
    }

    @Override
    public Claims validateToken(String token) {
        if(tokens.get(token) != null){
            try{
                return Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
            } catch(ExpiredJwtException e) {
                tokens.remove(token);
                return null;
            }
           
        }
        return null;
    }

    @Override
    public Integer removeToken(String token) {
        return tokens.remove(token);
        
    }
    
    private String getSecretKey() {
        return "AAAAB3NzaC1yc2EAAAADAQABAAABAQDFXM/3oTrq6EZCGVogx+w9At/uOSTdblone9oI8J6vho0EV5sVbEjvDPufyeXv4wLWciE7WPdBR6JNYNk4jokiyByS/Qrd3WH8+fRTuGWUQjC9fFb9";
    }
}
