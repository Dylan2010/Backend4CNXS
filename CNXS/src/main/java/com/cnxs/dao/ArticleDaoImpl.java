package com.cnxs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cnxs.bo.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao{
	
	@PersistenceContext(unitName="CNXS")
    private EntityManager em;

	@Override
	@Transactional
	public boolean create(Article article) {
		try{
			em.persist(article);
		} catch(PersistenceException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean update(Article article) {
		try{
			em.merge(article);
		} catch(PersistenceException e){
			return false;
		}
		return true;
	}

	@Override
	public Article get(int id) {
		return em.find(Article.class, id);
	}

}
