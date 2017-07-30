<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
</head>
<body>
<h1>ข้อมูลรหัสไปรษณีย์</h1>
	<form:form action="zipcodes.do" method="POST" commandName="zipcodes">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>districtCode</td>
				<td><form:input path="districtCode" /></td>
			</tr>
			<tr>
				<td>zipcode</td>
				<td><form:input path="zipcode" /></td>
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
		<th>ID</th>
		<th>districtCode</th>
		<th>zipcode</th>
		<c:forEach items="${zipcodesList}" var="zipcodes">
			<tr>
				<td>${zipcodes.id}</td>
				<td>${zipcodes.districtCode}</td>
				<td>${zipcodes.zipcode}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>