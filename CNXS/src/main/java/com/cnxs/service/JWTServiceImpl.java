package com.cnxs.service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTServiceImpl implements JWTService{
    
    private ConcurrentHashMap<String, Integer> tokens = new ConcurrentHashMap<String, Integer>();
    
    private static long EXPIRATION_DURATION = 24*60*60;
    
    private static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    
    public static void main(String args[]) {
        JWTServiceImpl jwtS = new JWTServiceImpl();
        String token = jwtS.registerToken(123);
        System.out.println(jwtS.validateToken(token));
    }

    @Override
    public String registerToken(int userId) {
        Long expirationTime = System.currentTimeMillis() + EXPIRATION_DURATION;
        String token =  Jwts.builder().setSubject("cnxs_token").claim("userId",
                userId)
                 .setExpiration(new Date(expirationTime))
                .signWith(SIGNATURE_ALGORITHM,       
                      getSecretKey()).compact();
        tokens.put(token, userId);
        return token;
    }

    @Override
    public int validateToken(String token) {
        if(tokens.get(token) != null){
            Claims claims = Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
            if(claims.getExpiration().getTime() < System.currentTimeMillis()) {
                tokens.remove(token);
                return -1;
            }
            return claims.get("userId", Integer.class);
        }
        return -1;
    }

    @Override
    public Integer removeToken(String token) {
        return tokens.remove(token);
        
    }
    
    private String getSecretKey() {
        return "AAAAB3NzaC1yc2EAAAADAQABAAABAQDFXM/3oTrq6EZCGVogx+w9At/uOSTdblone9oI8J6vho0EV5sVbEjvDPufyeXv4wLWciE7WPdBR6JNYNk4jokiyByS/Qrd3WH8+fRTuGWUQjC9fFb9";
    }
}
