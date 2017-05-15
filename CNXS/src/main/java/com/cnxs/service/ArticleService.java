package com.cnxs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnxs.bo.Article;
import com.cnxs.dao.ArticleDao;
import com.cnxs.dto.ArticleNewsListDTO;
import com.cnxs.enums.ArticleType;

@Service
public class ArticleService {
    
	//最大每页显示限制
    private static final int MAX_PAGE_LIMIT = 50;
    
	//默认每页条数
    private static final int DEFAULT_PAGE_LIMIT = 10;
    
	//默认偏移量
    private static final int DEFAULT_PAGE_OFFSET = 0;
	
	
	//获取文章
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
	
	//创建
	public boolean create(Article article, String type) {
		if(!isInValidType(type) && type.equals(article.getType().toString())) {
			return articleDao.create(article);
		}
		return false;
	}
	
	//更新
	public boolean update(Article article, String type, Integer id) {
        if(!isInValidType(type) && id != null && id == article.getId() && type.equals(article.getType().toString())) {
            return articleDao.update(article);
        }
        return false;
    }
	
	//搜索
	public List<Article> search(String keyword) {
		return articleDao.search(keyword);
	}
	
	//获取总数
	public long getArticleTotalCountByType(String type) {
		if(isInValidType(type)) {
			return 0;
		} else {
			return articleDao.getArticleTotalCountByType(ArticleType.valueOf(type));
		}
	}
	
	//获取列表
	public List<Article> getArticleList(String type, Integer offset, Integer limit) {
	    if(isInValidType(type)) {
	        return new ArrayList<Article>();
	    }
	    offset = offset == null ? DEFAULT_PAGE_OFFSET : offset;
	    limit = limit == null ? DEFAULT_PAGE_LIMIT : limit;
	    limit = limit > MAX_PAGE_LIMIT ? MAX_PAGE_LIMIT : limit;
	    return articleDao.getArticleList( ArticleType.valueOf(type), offset, limit);
	}
	
	//新闻动态
	public ArticleNewsListDTO getNewsList(Integer limit) {
		int pageLimit;
		pageLimit = limit == null ? DEFAULT_PAGE_LIMIT : limit;
		pageLimit = pageLimit > MAX_PAGE_LIMIT ? MAX_PAGE_LIMIT : pageLimit;
		
		ArticleNewsListDTO res = new ArticleNewsListDTO();
		res.setEvents(articleDao.getLastestArticleWithType(ArticleType.Events, 0, pageLimit));
		res.setExperts(articleDao.getLastestArticleWithType(ArticleType.Experts, 0, pageLimit));
		res.setInfo(articleDao.getLastestArticleWithType(ArticleType.Info, 0, pageLimit));
	    return res;
	}
	
	//判断非法类型
	private boolean isInValidType(String type) {
	    try{
	        ArticleType.valueOf(type);
	    } catch(IllegalArgumentException e) {
	        return true;
	    }
	    return  false;
	}
	
	//获取最新
	public Article getLatestArticle(String type, Boolean next, Date date) {
	    if(isInValidType(type)) {
            return null;
        }
	    return articleDao.getLatestArticle(date, next, ArticleType.valueOf(type));
	}
	
	//删除
	public Boolean deleteArticleByTypeAndId(String type, int id) {
	    return articleDao.deleteArticleByTypeAndId(ArticleType.valueOf(type), id);
	}
}
