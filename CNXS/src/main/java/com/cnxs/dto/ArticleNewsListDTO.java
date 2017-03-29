package com.cnxs.dto;

import java.util.List;

import com.cnxs.bo.Article;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleNewsListDTO {
	
	private List<Article> events;
	
	private List<Article> experts;
	
	@JsonProperty("informations")
	private List<Article> info;

	public List<Article> getEvents() {
		return events;
	}

	public void setEvents(List<Article> events) {
		this.events = events;
	}

	public List<Article> getExperts() {
		return experts;
	}

	public void setExperts(List<Article> experts) {
		this.experts = experts;
	}

	public List<Article> getInfo() {
		return info;
	}

	public void setInfo(List<Article> info) {
		this.info = info;
	}
}
