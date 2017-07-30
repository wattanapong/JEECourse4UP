<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
</head>
<body>
	<h1>-ข้อมูลจังหวัด</h1>
	<br>
	<table border="1">
		<th>อำเภอ ID</th>
		<th>อำเภอ</th>
		<th>ID</th>
		<th>รหัสจังหวัด</th>
		<th>จังหวัด</th>
		<th>ภาค</th>
		<c:forEach items="${provinces.amphureses}" var="amphures">
			<tr>
				<td>${amphures.amphurId }</td>
				<td>${amphures.amphurName }</td>
				<td>${provinces.id}</td>
				<td>${provinces.provinceCode}</td>
				<td>${provinces.provinceName}</td>
				<td>${provinces.geography.geoName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>