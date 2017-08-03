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
<c:if test="${ employee == null }">
	<h1>Employee id (empno) does not exist.</h1>
</c:if>

<c:if test="${ employee.empNo > 0 }">
	name : <c:out value="${employee.firstName }"></c:out> <c:out value="${employee.lastName }"></c:out><br>
	id : <c:out value="${employee.empNo }"></c:out> <br>
	<c:set var="id" value="${employee.empNo+1 }" />
	<a href="emp?id=<c:out value="${employee.empNo-1 }"/>">Previous</a> | <a href="emp?id=<c:out value="${employee.empNo+1 }"/>">next</a>
</c:if>
</body>
</html>

