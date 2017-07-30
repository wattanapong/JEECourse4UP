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
	<h1>-ข้อมูลภาค</h1>
	<form:form action="districts.do" method="POST" commandName="districts">
		<table>
			<tr>
				<td>ตำบล ID</td>
				<td><form:input path="districtId" /></td>
			</tr>
			<tr>
				<td>ตำบล</td>
				<td><form:input path="districtName" /></td>
			</tr>
			<tr>
				<td>อำเภอ</td>
				<td><form:select path="amphures.amphurId"
						items="${amphuresList }" /></td>
			</tr>
			<tr>
				<td>จังหวัด</td>
				<td><form:select path="amphures.provinces.id"
						items="${provincesList }" /></td>
			</tr>

			<tr>
				<td>ไปรษณีย์</td>
				<td><input type="text" name="districtCode" value="${zipcodes }"></td>
			</tr>

			<tr>
				<td>ภาค</td>
				<td><form:select path="amphures.provinces.geography.id"
						items="${geoGraphyList }" /></td>
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
		<th>ตำบล ID</th>
		<th>ตำบล</th>
		<th>อำเภอ</th>
		<th>จังหวัด</th>
		<th>ไปรษณีย์</th>
		<th>ภาค</th>
		<c:forEach items="${districtsList}" var="districts"
			varStatus="zipcode">
			<tr>
				<td>${districts.districtId}</td>
				<td>${districts.districtName}</td>
				<td>${districts.amphures.amphurName}</td>
				<td>${districts.amphures.provinces.provinceName}</td>
				<td>${zipcodes[zipcode.index] }</td>
				<td>${districts.amphures.provinces.geography.geoName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>