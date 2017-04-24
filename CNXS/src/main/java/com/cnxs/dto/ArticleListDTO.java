package com.cnxs.dto;

import java.util.List;

import com.cnxs.bo.Article;

public class ArticleListDTO {
	
	private long totalCount;
	
	private List<Article> articles;

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
