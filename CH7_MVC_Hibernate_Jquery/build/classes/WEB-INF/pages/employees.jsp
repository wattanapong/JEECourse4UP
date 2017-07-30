<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees Management</title>
</head>
<body>
	<h1>Employees Data</h1>
	<form:form action="Employees.do" method="POST" commandName="employees">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="empNo" /></td>
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
				<td><form:input path="birthDate" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="hireDate" /></td>
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
		<th>empNo</th>
		<th>User</th>
		<th>Password</th>
		<th>Birth Date</th>
		<th>First name</th>
		<th>Last name</th>
		<th>Gender</th>
		<th>Hire Date</th>
		<c:forEach items="${employeesList}" var="employees">
			<tr>
				<td>${employees.empNo}</td>
				<td>${employees.user}</td>
				<td>${employees.pass}</td>
				<td>${employees.birthDate}</td>
				<td>${employees.firstName}</td>
				<td>${employees.lastName}</td>
				<td>${employees.gender}</td>
				<td>${employees.hireDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>