<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.business.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Of Users</title>
</head>
<style type="text/css">
#table-design {
	border: 1px solid #DFDFDF;
	background-color: #F9F9F9;
	width: 100%;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	font-family: Arial,"Bitstream Vera Sans",Helvetica,Verdana,sans-serif;
	color: #333;
}
#table-design td, #table-3 th {
	border-top-color: white;
	border-bottom: 1px solid #DFDFDF;
	color: #555;
}
#table-design th {
	text-shadow: rgba(255, 255, 255, 0.796875) 0px 1px 0px;
	font-family: Georgia,"Times New Roman","Bitstream Charter",Times,serif;
	font-weight: normal;
	padding: 7px 7px 8px;
	text-align: left;
	line-height: 1.3em;
	font-size: 14px;
}
#table-design td {
	font-size: 12px;
	padding: 4px 7px 2px;
	vertical-align: top;
}
</style>
<body>
	<table id="table-design">
	<thead>
		<th>Name: </th>
		<th>Username: </th>
	</thead>
	<tbody>
	<%
		List<User> userList = new ArrayList<User>();
		userList = (List<User>)(request.getSession().getAttribute("userList"));
		
		for( int i = 0; i < userList.size(); i++ ){
			%>
			<tr>
				<td><%=userList.get(i).getFirstName() %> <%=userList.get(i).getLastName() %></td>
				<td><%=userList.get(i).getUsername() %></td>
			</tr>
			<%
		}
%>	</tbody>
	</table>
	<a href="loginSuccess.jsp">Return to Main page...</a>
</body>
</html>