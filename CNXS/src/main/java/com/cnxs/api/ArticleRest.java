package com.cnxs.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnxs.bo.Article;
import com.cnxs.dto.ArticleListDTO;
import com.cnxs.dto.ArticleNewsListDTO;
import com.cnxs.service.ArticleService;

@RestController
@RequestMapping(value = { "Articles/v1" })
public class ArticleRest {
	
	@Autowired
	private ArticleService articleSrv;
	
	//文章查询
	@RequestMapping(value = "/Type/{type}/id/{id}",method = RequestMethod.GET)
    public ResponseEntity<Article> getArticleByTypeAndId(@PathVariable String type,@PathVariable int id) {
		Article res = articleSrv.getArtiCleByIdAndType(type, id);
        return res == null ? new ResponseEntity<Article>(res, HttpStatus.NOT_FOUND)  : new ResponseEntity<Article>(res, HttpStatus.OK);
    }
	
	//文章删除
	@RequestMapping(value = "/Type/{type}/id/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteArticle(@PathVariable String type,@PathVariable int id) {
	    boolean res = articleSrv.deleteArticleByTypeAndId(type, id);
	    return res  ? new ResponseEntity<Boolean>(res, HttpStatus.OK)  : new ResponseEntity<Boolean>(res, HttpStatus.BAD_REQUEST);
    }
	
	//文章新增/修改
	@RequestMapping(value = "/Type/{type}/id/{id}",method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateArticle(@PathVariable String type, @PathVariable Integer id,@RequestBody Article article) {
        boolean res = articleSrv.update(article, type,id );
        return res  ? new ResponseEntity<Boolean>(res, HttpStatus.OK)  : new ResponseEntity<Boolean>(res, HttpStatus.BAD_REQUEST);
    }
	
	//文章类型
	@RequestMapping(value = "/Type/{type}", method = RequestMethod.POST) 
	public ResponseEntity<Boolean> createArticle(@PathVariable String type, @RequestBody Article article) {
		boolean success = articleSrv.create(article, type);
		return success ? new ResponseEntity<>(success, HttpStatus.CREATED) : new ResponseEntity<>(success, HttpStatus.BAD_REQUEST);
	}
	
	//文章列表
	@RequestMapping(value = "/Type/{type}/list", method = RequestMethod.GET) 
    public @ResponseBody Object listTypeArticle(@PathVariable String type, @RequestParam(required=false) Integer limit, @RequestParam(required=false) Integer offset, @RequestParam(required=false, defaultValue="false") Boolean totalCountRequired) {
		List<Article> articleList = articleSrv.getArticleList(type, offset, limit);
		if(!totalCountRequired){
			return articleList;
		} else {
			ArticleListDTO dto = new ArticleListDTO();
			dto.setArticles(articleList);
			dto.setTotalCount(articleSrv.getArticleTotalCountByType(type));
			return dto;
		} 
    }
	
	//新闻动态
	@RequestMapping(value = "/News", method = RequestMethod.GET)
	public @ResponseBody ArticleNewsListDTO getNewsList(@RequestParam(required=false) Integer limit) {
	    return articleSrv.getNewsList(limit);
	}
	
	//最新文章
	@RequestMapping(value = "/Type/{type}/latest", method = RequestMethod.GET) 
    public ResponseEntity<Article> getLatestArticle(@PathVariable String type, @RequestParam Boolean next, @RequestParam("date") Long date) {
	    Article res = articleSrv.getLatestArticle(type, next, new Date(date));
        return res == null ? new ResponseEntity<>(res, HttpStatus.NO_CONTENT) : new ResponseEntity<>(res, HttpStatus.OK);
    }
	
	//搜索
	@RequestMapping(value = "/search", method = RequestMethod.GET) 
    public @ResponseBody List<Article> search(@RequestParam String keyword) {
	    return articleSrv.search(keyword);
    }
	
}
