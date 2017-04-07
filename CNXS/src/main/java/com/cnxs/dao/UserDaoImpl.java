package com.cnxs.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cnxs.bo.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    
    @PersistenceContext(unitName="CNXS")
    private EntityManager em;

	@Override
	public int createUser(User user) {
		try{
			em.persist(user);
			return user.getId();
		} catch(PersistenceException e) {
			return -1;
		}
	}

	@Override
	public User findUserByAccount(User user) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("account"), user.getAccount()));
		try{
		    return em.createQuery(criteriaQuery).getSingleResult();
		} catch(NoResultException e) {
		    return null;
		}
		
	}

    @Override
    public boolean updateUser(User user) {
        try{
            em.merge(user);
            return true;
        } catch(PersistenceException e) {
            return false;
        }
    }

}
