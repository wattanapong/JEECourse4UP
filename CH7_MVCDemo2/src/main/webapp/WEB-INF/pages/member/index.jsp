<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<%@ include file="/WEB-INF/pages/external.jsp"%>

<div class="panel panel-default">
	<div class="panel-heading">Manage Member</div>
	<div class="panel-body">

		<table class="table table-bordered">
			<thead>
				<tr>
					<td><input type="checkbox" name="noAll"></td>
					<td>No.</td>
					<td>user</td>
					<td>name</td>
					<td>created</td>
					<td>address</td>
					<td>district</td>
					<td colspan="2">Manage</td>
				</tr>
			</thead>
			<tbody>

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
							type="submit" name="action" value="Delete" /> <input
							type="submit" name="action" value="Search" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
</body>
</html>