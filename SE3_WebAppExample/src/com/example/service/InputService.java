package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Input;
import com.example.dao.InputDao;
import com.example.exceptions.DaoException;

public class InputService {

	InputDao dao = new InputDao();
	
	public boolean createPost(String title, String text, String category) {
		
		boolean input = false;
		// call method to insert post to db
		try {
			input = dao.createPost(title, text, category);
		} catch (DaoException e){
			e.printStackTrace();
		}
		return input;
	}
	
	public List<Input> viewPost() {
		List<Input> i = new ArrayList<Input>();
		
		//call method to select all the posts from the db
		try {
			i = dao.viewPosts();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return i;
	}
}
