package com.cnxs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cnxs.bo.User;

@Repository
public class UserDaoImpl implements UserDao{
    
    @PersistenceContext(unitName="CNXS")
    private EntityManager em;

    public User getUserById(int id) {
        // TODO Auto-generated method stub
        return em.find(User.class, id);
    }

}
