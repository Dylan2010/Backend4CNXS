package com.cnxs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnxs.bo.Article;
import com.cnxs.dao.ArticleDao;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	public Article getArtiCleByIdAndType(String type, int id){
		Article res = articleDao.get(id);
		if(null == res || !type.equals(res.getType())) {
			return null;
		} else {
			return res;
		}
	}
	
	public boolean create(Article article, String type) {
		if(type.equals(article.getType())) {
			return articleDao.create(article);
		}
		return false;
	}
	
}
