package com.cnxs.dao;


import com.cnxs.bo.User;

public interface UserDao {
    
	//创建用户
    public int createUser(User user);
    
	//查找
    public User findUserByAccount(User user);
    
	//更新
    public boolean updateUser(User user);
}
