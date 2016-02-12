package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class ListUsersCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse) {
		
		UserService userService = new UserService();
		String forwardToJsp = "";
		
		List<User> userList = new ArrayList<User>();
		
		// select all the users in the db
		userList = userService.getAllUsers();
		
		if(!userList.isEmpty()) {

			//if the user list is not empty, store list in session
			HttpSession session = request.getSession();
			session.setAttribute("userList", userList);
			
			//forward to the list of users page
			forwardToJsp = "/ListUsers.jsp";				
		}
		else{
			forwardToJsp = "/errorPage.jsp";	
		}
		return forwardToJsp;
	}

}
