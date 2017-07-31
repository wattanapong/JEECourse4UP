<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "jspuser", "jsp2017");
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM employees LIMIT 0,1000");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<h1>Index.jsp</h1>

	<table>
		<tr>
			<th>emp_no</th>
			<th>birth date</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>gender</th>
			<th>hire date</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getString("emp_no") %></td>
			<td><%=rs.getString("birth_date") %></td>
			<td><%=rs.getString("first_name") %></td>
			<td><%=rs.getString("last_name") %></td>
			<td><%=rs.getString("gender") %></td>
			<td><%=rs.getString("hire_date") %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>