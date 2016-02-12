package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.example.service.InputService;

public class CreatePostCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		InputService inputService = new InputService();
		String forwardToJsp = "";
		
		//Get data entered from request
		String title = request.getParameter("title");
		String text = request.getParameter("body");
		String category = request.getParameter("category");
		boolean insert = false;
		
		// create the post
		insert = inputService.createPost(title, text, category);
		
		//if inserted correctly..
		if(insert == true){
			//forward to main page
			forwardToJsp = "/loginSuccess.jsp";				
		}
		else{
			forwardToJsp = "/errorPage.jsp";	
		
		}
		
		return forwardToJsp;
	}

}
