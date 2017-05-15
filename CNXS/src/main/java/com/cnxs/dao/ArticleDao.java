package com.cnxs.dao;

import java.util.Date;
import java.util.List;

import com.cnxs.bo.Article;
import com.cnxs.enums.ArticleType;

public interface ArticleDao {
	
	//创建文章
	public boolean create(Article article);
	
	//更新
	public boolean update(Article article);
	
	//current deletion is soft delete
	public boolean deleteArticleByTypeAndId(ArticleType type, int id);
	
	//获取
	public Article get(int id);
	
	//根据类型获取
	public List<Article> getLastestArticleWithType(ArticleType type, int offset, int limit);
	
	//获取文章列表
	public List<Article> getArticleList(ArticleType type, int offset, int limit);
	
	//上一篇/下一篇
	public Article getLatestArticle(Date date, Boolean next, ArticleType type);
	
	//搜索
	public List<Article> search(String keyword);
	
	//总数
	public long getArticleTotalCountByType(ArticleType type);
}
