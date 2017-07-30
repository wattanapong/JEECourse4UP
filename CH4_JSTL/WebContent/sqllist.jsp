<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employees</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<sql:setDataSource var="query" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/employees" user="root" password="" />
	<c:set var="count" value="20" />
	<c:set var="start" value="${ (param.page-1)*count }" />
	<c:set var="page" value="${ param.page}" />
	<c:if test="${param.page == null || param.page <=0 }">
		<c:set var="start" value="0" />
		<c:set var="page" value="1" />
	</c:if>

	<sql:query dataSource="${query}" var="resultcount">
		<c:out value="SELECT count(*) from employees" />
	</sql:query>
	<%-- <c:set var="num" value="${ resultcount.rowCount}" /> --%>
	<c:set var="num" value="${resultcount.rowsByIndex[0][0] }" />

	<c:set var="sql" value="SELECT * from employees limit ${start},${count }" />
	SQL <c:out value="${sql }" />
	
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
	<c:forEach var="i" begin="${page-10>0?(page-10):1 }" step="1" end="${page+10<num?(page+10):num }">
		<c:choose>
		<c:when test="${i !=page }">
			<a href="sqllist.jsp?page=<c:out value="${i}" />"><c:out value="${i}" /></a>
		</c:when>
		<c:otherwise>
				<c:out value="${page }" />
		</c:otherwise>
		</c:choose>
	</c:forEach>
</body>


