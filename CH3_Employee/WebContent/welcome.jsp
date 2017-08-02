<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<%
String user = (String) session.getAttribute("user");
if (user == null) response.sendRedirect("login.jsp");
%>
ยินดีต้อนรับ <%=user %>  <a href="logout">logout</a>
</body>
</html>