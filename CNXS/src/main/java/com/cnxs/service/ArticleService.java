package com.cnxs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnxs.bo.Article;
import com.cnxs.dao.ArticleDao;
import com.cnxs.enums.ArticleType;

@Service
public class ArticleService {
    
    private static final int MAX_PAGE_LIMIT = 50;
    
    private static final int DEFAULT_PAGE_LIMIT = 10;
    
    private static final int DEFAULT_PAGE_OFFSET = 0;
	
	@Autowired
	private ArticleDao articleDao;
	
	public Article getArtiCleByIdAndType(String type, int id){
	    if(isInValidType(type)) {
	        return null;
	    }
		Article res = articleDao.get(id);
		if(null == res || !type.equals(res.getType().toString())) {
			return null;
		} else {
			return res;
		}
	}
	
	public boolean create(Article article, String type) {
		if(!isInValidType(type) && type.equals(article.getType().toString())) {
			return articleDao.create(article);
		}
		return false;
	}
	
	public boolean update(Article article, String type, Integer id) {
        if(!isInValidType(type) && id != null && id == article.getId() && type.equals(article.getType().toString())) {
            return articleDao.update(article);
        }
        return false;
    }
	
	public List<Article> getArticleList(String type, Integer offset, Integer limit) {
	    if(isInValidType(type)) {
	        return new ArrayList<Article>();
	    }
	    offset = offset == null ? DEFAULT_PAGE_OFFSET : offset;
	    limit = limit == null ? DEFAULT_PAGE_LIMIT : limit;
	    limit = limit > MAX_PAGE_LIMIT ? MAX_PAGE_LIMIT : limit;
	    return articleDao.getArticleList( ArticleType.valueOf(type), offset, limit);
	}
	
	public List<Article> getNewsList() {
	    return articleDao.getNewsList();
	}
	
	private boolean isInValidType(String type) {
	    try{
	        ArticleType.valueOf(type);
	    } catch(IllegalArgumentException e) {
	        return true;
	    }
	    return  false;
	}
	
	public Article getLatestArticle(String type, Boolean next, Date date) {
	    if(isInValidType(type)) {
            return null;
        }
	    return articleDao.getLatestArticle(date, next, ArticleType.valueOf(type));
	}
}
