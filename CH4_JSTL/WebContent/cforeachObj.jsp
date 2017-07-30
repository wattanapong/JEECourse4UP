<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>C tags</title>
</head>
<body>
	<c:forEach var="employee" items="${employees }">
 	 Employee#<c:out value="${employee.id }"></c:out> Name = <c:out value="${employee.name}"/> <br>
	</c:forEach>
</body>
</html>


