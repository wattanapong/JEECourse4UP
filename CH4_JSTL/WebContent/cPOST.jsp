<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>POST</title>
</head>
<body>
User : ${param.user }<br>
Pass : ${param.pass }<br>
<hr>
User from JSP Tag : <%=request.getParameter("user") %> <br>
<%
String user = request.getParameter("user");
if ( user != null && user.equals("admin")) response.getWriter().println("Welcome");
else response.getWriter().println("Fail");
%>
<hr>
	<form action="cPOST.jsp" method="get">
		User : <input type="text" name="user"><br> 
		Pass : <input type="password" name="pass"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>
