package com.cnxs.dao;


import com.cnxs.bo.User;

public interface UserDao {
    
    public int createUser(User user);
    
    public User findUserByAccount(User user);
    
}
