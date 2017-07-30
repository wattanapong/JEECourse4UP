<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<c:forEach items="${amphuresList}" var="amphures">
	<option value="${amphures.amphurId }">${amphures.amphurName }</option>
</c:forEach>