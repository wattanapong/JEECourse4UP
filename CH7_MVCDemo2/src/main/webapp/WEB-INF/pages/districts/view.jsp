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
	<h1>ข้อมูลภาค</h1>
	<br>
	<c:if test="${msg != '' }">${msg }</c:if>
	<br>
	<table border="1">
		<th>ตำบล ID</th>
		<th>ตำบล</th>
		<th>อำเภอ</th>
		<th>จังหวัด</th>
		<th>ไปรษณีย์</th>
		<th>ภาค</th>

		<c:if test="${msg == '' }">
			<tr>
				<td>${districts.districtId}</td>
				<td>${districts.districtName}</td>
				<td>${districts.amphures.amphurName}</td>
				<td>${districts.amphures.provinces.provinceName}</td>
				<td>${zipcodes.zipcode }</td>
				<td>${districts.amphures.provinces.geography.geoName}</td>
			</tr>
		</c:if>
	</table>

</body>
</html>