<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management</title>

<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>

</head>
<body>
	<h1>Students Data[ข้อมูลนักเรียน]</h1>
	<form:form action="Person.do" method="POST" commandName="person">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>User</td>
				<td><form:input path="user" /></td>
			</tr>
			<tr>
				<td>Pass</td>
				<td><form:input path="pass" /></td>
			</tr>
			<tr>
				<td>First name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" /> <input
					type="submit" name="action" value="Delete" /> <input type="submit"
					name="action" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<table border="1">
		<th>ID</th>
		<th>User</th>
		<th>Password</th>
		<th>First name</th>
		<th>Last name</th>
		<c:forEach items="${personList}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.user}</td>
			<td>${person.pass}</td>
			<td>${person.name}</td>
			<td>${person.lname}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>