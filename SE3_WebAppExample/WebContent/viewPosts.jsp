<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.business.Input" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Posts</title>
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
	<%
		List<Input> postList = new ArrayList<Input>();
		postList = (List<Input>)(request.getSession().getAttribute("postList"));
		
		for( int i = 0; i < postList.size(); i++ ){
			%>
			<thead>
				<th>
					<%=postList.get(i).getTitle() %>
				</th>
				<th>
					<%=postList.get(i).getCategory() %>
				</th>
			</thead>
			<tbody>
				<tr>
					<td><%=postList.get(i).getBody() %></td>
				</tr>
			</tbody>
			<%
		}
%>
	</table>
	
<hr />

<form action="FrontController" method="post">
                <table id="table-design" align="left">
                    <tr>
                        <td> Create a Post  : </td>
                    </tr>
                    <tr>
						<td>Enter Title: </td><td> <input name="title" size=15 type="text" /> </td> 
					</tr>
					<tr>
						<td>Enter Body:	</td><td> <TEXTAREA name="body" rows=3 cols=30 ></TEXTAREA> </td>
					</tr>
					<tr>
						<td>Enter Category:	</td><td> <input name="category" size=15 type="text" /> </td>
                    </tr>
                    <tr>
                    	<td>
                    		<input type="hidden" name="action" value="CreatePost" />
                			<input type="submit" value="Add Post"  />
                    	</td>
                    </tr>
                </table>
                
                
            </form>
            <a href="loginSuccess.jsp">Return to Main page...</a>
</body>
</html>