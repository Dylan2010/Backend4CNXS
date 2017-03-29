package com.cnxs.dao;

import java.util.Date;
import java.util.List;

import com.cnxs.bo.Article;
import com.cnxs.enums.ArticleType;

public interface ArticleDao {
	
	public boolean create(Article article);
	
	public boolean update(Article article);
	
	//current deletion is soft delete
	public boolean deleteArticleByTypeAndId(ArticleType type, int id);
	
	public Article get(int id);
	
	public List<Article> getLastestArticleWithType(ArticleType type, int offset, int limit);
	
	public List<Article> getArticleList(ArticleType type, int offset, int limit);
	
	public Article getLatestArticle(Date date, Boolean next, ArticleType type);
}
