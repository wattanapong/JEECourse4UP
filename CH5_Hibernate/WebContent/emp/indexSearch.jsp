<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hibernate Employees</title>
</head>

<body>
<span style="float: right;"> <a
			href="formSearch?start=${start-40>0?start-40:0 }">Back</a> || <a
			href="formSearch?start=${start }">Next</a>
		</span>
		
<h3>found ${size } employees</h3>
	<form action="formSearch" method="post">
		<table>
			<thead>
				<tr>
					<td>EmpNo.</td>
					<td>Firstname</td>
					<td>LastName</td>
					<td>Gender</td>
				</tr>
				<tr>
					<td><input type="text" name="empno"></td>
					<td><input type="text" name="firstname"></td>
					<td><input type="text" name="lastname"></td>
					<td><select name="gender">
							<option value="ALL">all</option>
							<option value="M">male</option>
							<option value="F">female</option>
						</select></td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="employee" items="${employees }" begin="0" end="20">
					<tr>
						<td>${employee.empNo }</td>
						<td>${employee.firstName }</td>
						<td>${employee.lastName }</td>
						<td>${employee.gender }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<input type="submit" value="Search" name="search" style="float: left;">
		
	</form>
</body>
</html>

