<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
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
	<!--Servlet forwarded to me... loginSuccess.jsp -->
	
	<br/><br/>

	<br/><br/>
	<table id="table-design">
		<thead>
			<c:set var="user" value="${sessionScope.user}"/>
			<th>Hello <c:out value="${user.firstName}"/>, you are now logged in...</th>
			<th>What would like to do?</th>
		</thead>
		<tbody>
		<tr>
			<td>
			<form action="FrontController" method="post">
			     <input type="hidden" name="action" value="ListUsers" />
		         <input type="submit" value="List Users" />
		    </form>
		    </td>
		</tr>
		<tr>
			<td>
		    <form action="FrontController" method="post">
			     <input type="hidden" name="action" value="ViewPosts" />
		         <input type="submit" value="View Posts" />
		    </form>
		    </td>
		</tr>
	    </tbody>      
	</table>
	<a href="login.html">Logout</a>
</body>

</html>