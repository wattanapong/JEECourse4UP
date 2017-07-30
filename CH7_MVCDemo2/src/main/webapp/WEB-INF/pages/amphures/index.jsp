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
	<form:form action="amphures.do" method="POST" commandName="amphures">
		<table>
			<tr>
				<td>รหัสอำเภอ</td>
				<td><form:input path="amphurId" /></td>
			</tr>
			<tr>
				<td>หมายเลขอำเภอ</td>
				<td><form:input path="amphurCode" /></td>
			</tr>
			<tr>
				<td>อำเภอ</td>
				<td><form:input path="amphurName" /></td>
			</tr>
			<tr>
				<td>จังหวัด</td>
				<td><form:select path="provinces.id" items="${provincesList }" /></td>
			</tr>

			<tr>
				<td>ภาค</td>
				<td><form:select path="provinces.geography.id"
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
		<th>รหัสอำเภอ</th>
		<th>หมายเลขอำเภอ</th>
		<th>อำเภอ</th>
		<th>จังหวัด</th>
		<th>ภูมิภาค</th>
		<c:forEach items="${amphuresList}" var="amphures">
			<tr>
				<td>${amphures.amphurId}</td>
				<td>${amphures.amphurCode}</td>
				<td>${amphures.amphurName}</td>
				<td>${amphures.provinces.provinceName}</td>
				<td>${amphures.provinces.geography.geoName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>