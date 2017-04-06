package com.cnxs.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cnxs.enums.ArticleType;
import com.cnxs.utils.DateToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name = "article")
public class Article extends BusinessObjectBase{
	
	@Id
	private int id;
	
	private String title;
	
	private String summary;
	
	private String content;
	
	@Enumerated(EnumType.STRING)
	private ArticleType type;
	
	@Column(name="imageinfo")
	private String imageInfo;
	
	@Column(name="eventdate")
	@JsonSerialize(using = DateToStringSerializer.class)
    private Date eventDate;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getImageInfo() {
		return imageInfo;
	}

	public void setImageInfo(String imageInfo) {
		this.imageInfo = imageInfo;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
