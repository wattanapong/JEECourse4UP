<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<c:if test="${All ==1}">
	<select <c:if test="${readonly eq '1' }">disabled</c:if>>
</c:if>
<c:forEach items="${districtsList}" var="districts">
	<option value="${districts.districtId }">${districts.districtName }</option>
</c:forEach>
<c:if test="${All ==1}">
	</select>
</c:if>