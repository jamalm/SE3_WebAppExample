package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.business.Input;
import com.example.service.InputService;

public class ViewPostsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		InputService inputService = new InputService();
		String forwardToJsp = "";
		
		//create list of posts 
		List<Input> postList = new ArrayList<Input>();
		
		//grab posts from db
		postList = inputService.viewPost();
		
		if(!postList.isEmpty()) {
			
			//if not empty , store in session
			HttpSession session = request.getSession();
			session.setAttribute("postList", postList);

			//forward to posts page
			forwardToJsp = "/viewPosts.jsp";				
		}
		else{
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}
}
