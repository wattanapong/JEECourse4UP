<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<%
	int i = 1;
%>
<c:forEach items="${members}" var="member">
	<tr>
		<td><input type="checkbox" name="no"></td>
		<td><%=i++%></td>
		<td>${member.user }</td>
		<td>${member.name }</td>
		<td>${member.created }</td>
		<td>${member.address }</td>
		<td>${member.districts.districtName }</td>
		<td><input type="submit" name="action" value="Edit" /> <input
			type="submit" name="action" value="Delete" /> <input type="submit"
			name="action" value="Search" /></td>
	</tr>
</c:forEach>