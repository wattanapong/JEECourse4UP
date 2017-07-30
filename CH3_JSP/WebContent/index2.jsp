<%@page import="com.jee.ch3.MySQL"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mysql" class="com.jee.ch3.MySQL"></jsp:useBean>
<% 
	mysql = new MySQL();
	if ( mysql.connect("localhost","", "employees", "jspuser", "jsp2016") ){
		mysql.Query("SELECT * FROM employees");	
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connect Mysql Used Bean</title>
</head>
<body>
<h1>Index2.jsp</h1>

	<table>
		<tr>
			<th>emp_no</th>
			<th>birth date</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>gender</th>
			<th>hire date</th>
		</tr>
		<%while(mysql.rs.next()){ %>
		<tr>
			<td><%=mysql.rs.getString("emp_no") %></td>
			<td><%=mysql.rs.getString("birth_date") %></td>
			<td><%=mysql.rs.getString("first_name") %></td>
			<td><%=mysql.rs.getString("last_name") %></td>
			<td><%=mysql.rs.getString("gender") %></td>
			<td><%=mysql.rs.getString("hire_date") %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>