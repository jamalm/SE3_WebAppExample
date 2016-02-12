package com.example.business;

import java.io.Serializable;

public class Input implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String body;
	private String category;
	
	public Input(int id, String title, String body, String category) {
		
		setId(id);
		setTitle(title);
		setBody(body);
		setCategory(category);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
