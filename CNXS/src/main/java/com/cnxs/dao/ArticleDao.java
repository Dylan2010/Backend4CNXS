package com.cnxs.dao;

import com.cnxs.bo.Article;

public interface ArticleDao {
	
	public boolean create(Article article);
	
	public boolean update(Article article);
	
	public Article get(int id);
}
