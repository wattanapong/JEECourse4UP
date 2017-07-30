<%@page import="com.jee.ch3.Employee"%>
<%@page import="com.jee.ch3.SetEmployees"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employee</title>
</head>
<body>
<%
	SetEmployees emplist = new SetEmployees();
	ArrayList<Employee> employees = emplist.getEmployees();
%>
	<table border="1" width="100%">
		<tr>
			<th>emp_no</th>
			<th>birth_date</th>
			<th>first_name</th>
			<th>last_name</th>
			<th>gender</th>
			<th>hire_date</th>
		</tr>
		<% for (Employee employee : employees) {	%>
		<tr>
			<td><%=employee.getEmp_no() %></td>
			<td><%=employee.getBirth_date() %></td>
			<td><%=employee.getFirst_name() %></td>
			<td><%=employee.getLast_name() %></td>
			<td><%=employee.getGender() %></td>
			<td><%=employee.getHire_date() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>