<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employees</title>
</head>
<body>
	<sql:setDataSource var="query" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/employees" user="root" password="" />

	<c:set var="sql" value="SELECT * from employees limit 0,20" />

	<sql:query dataSource="${query}" var="result">
		<c:out value="${sql }" />
	</sql:query>

	<table border="1" width="100%">
		<tr>
			<th>Emp ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.emp_no}" /></td>
				<td><c:out value="${row.first_name}" /></td>
				<td><c:out value="${row.last_name}" /></td>
				<td><c:out value="${row.gender}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>