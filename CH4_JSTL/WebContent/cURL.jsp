<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>C:URL</title>
</head>
<body>
	<c:url value="cPOST.jsp" var="myURL">
		<c:param name="user" value="watt" />
		<c:param name="pass" value="1234" />
	</c:url>
	<c:import url="${myURL}" />
	
	<a href='<c:url value="${myURL }"></c:url>'>login</a> <br>
</body>
</html>
