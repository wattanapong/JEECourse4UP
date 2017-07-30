<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>C tags</title>
</head>
<body>

	<c:set var="names" value="ณัฐวุฒิ,ธนพล,นิพิษฐา,พุทธิพัทธ์,ศรัณย์,สยามรัฐ,พันธกานต์,พิชัย,ฐากูร,ทศพล,ทักษิณ,รณกรณ์,วศิน,สุรเชษฐ์,วรพล" scope="page" />
	
	<c:set var="i" value="0" />
	<c:forEach var="name" items="${names }" varStatus="status" >
	<c:if test="${i%3==0 }">
 			Group 1 :
 	</c:if>
 	<c:if test="${i%3==1 }">
 		Group 2 :
 	</c:if>
 	<c:if test="${i%3==2 }">
 		Group 3 :
 	</c:if>
 	<fmt:parseNumber var="no" integerOnly="true"  type="number" value="${1+i/3}" />
 	#<c:out value="${no}" /> name = <c:out value="${name}" /><br>
 	<c:set var="i" value="${i+1 }" />
	</c:forEach>
</body>
</html>


