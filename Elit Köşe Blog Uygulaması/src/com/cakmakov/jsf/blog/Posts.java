package com.cakmakov.jsf.blog;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Posts {

	private int id;
	private String date;
	private String title;
	private String content;
	
	public Posts() {
		
	}
	
	public Posts(int id, String date, String title, String content) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", date=" + date + ", title=" + title + ", content=" + content + "]";
	}
	
}
