package com.cnxs.dao;

import java.util.List;

import com.cnxs.bo.Article;
import com.cnxs.enums.ArticleType;

public interface ArticleDao {
	
	public boolean create(Article article);
	
	public boolean update(Article article);
	
	public Article get(int id);
	
	public List<Article> getNewsList();
	
	public List<Article> getArticleList(ArticleType type, int offset, int limit);
}
