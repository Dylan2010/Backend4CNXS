package com.cnxs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cnxs.bo.Article;
import com.cnxs.enums.ArticleType;

@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao{
	
	@PersistenceContext(unitName="CNXS")
    private EntityManager em;

	@Override
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

    @Override
    public List<Article> getNewsList() {
        List<Article> list = new ArrayList<>(3);
        for(ArticleType type : ArticleType.values()) {
            list.addAll(this.getLastestArticleWithType(type,0, 1));
        }
        
        return list;
    }
    
    private List<Article> getLastestArticleWithType(ArticleType type, int offset, int limit) {
        TypedQuery<Article> query = em.createQuery("Select A FROM Article A where A.type= :type ORDER BY A.creationTime desc", Article.class);
        query.setParameter("type", type);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Override
    public List<Article> getArticleList(ArticleType type, int offset, int limit) {
        return getLastestArticleWithType(type, offset, limit);
    }

}
