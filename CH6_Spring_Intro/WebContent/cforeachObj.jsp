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

		<c:set var="i" value="1"/>
		<c:forEach var="person" items="${allperson }">
			<c:if test="${ i ==1 }">
				${person.type } <c:set var="i" value="2"/>
			</c:if>
			<h4>${person.fname } ${person.lname }</h4>
		</c:forEach>
</body>
</html>


