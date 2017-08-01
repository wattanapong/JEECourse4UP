<%@page import="com.jee.ch3.SetUser"%>
<%@page import="com.jee.ch3.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List user</title>
</head>
<body>
<%
	SetUser userList = new SetUser();
	ArrayList<User> users = userList.getUsers();
%>
	<table border="1" width="100%">
		<tr>
			<th>id</th>
			<th>first name</th>
			<th>last name</th>
			<th>code</th>
			<th>major</th>
		</tr>
		<% for (User user : users) {	%>
		<tr>
			<td><%=user.getId() %></td>
			<td><%=user.getFirst_name() %></td>
			<td><%=user.getLast_name() %></td>
			<td><%=user.getCode() %></td>
			<td><%=user.getMajor() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>