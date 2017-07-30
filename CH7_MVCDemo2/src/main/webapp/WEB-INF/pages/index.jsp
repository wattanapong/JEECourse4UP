<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp"%>
<%@ include file="/WEB-INF/pages/external.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Demo</title>
</head>
<body>
	<div class="container-fluid" style="margin-top: 50px;">
		<div class="row">
			<div class="col-md-2">
				<div class="panel panel-default">
					<div class="panel-heading">Menu</div>
					<ul class="list-group">
						<a href="geography" class="list-group-item">geography</a>
						<a href="provinces" class="list-group-item">provinces</a>
						<a href="zipcodes" class="list-group-item">zipcodes</a>
						<a href="amphures" class="list-group-item">amphures</a>
						<a href="districts" class="list-group-item">districts</a>
					</ul>
				</div>
			</div>
			<div class="col-md-10">
				<h1 class="text-center">Member Page</h1>
				<div class="container-fluid">
					<div class="row">

						<div class="panel panel-default">
							<div class="panel-heading">Create Member</div>
							<div class="panel-body">
								<form:form action="member/create" method="POST" id="members"
									modelAttribute="members" commandName="member">
									<button id="p10">+10</button>
									<table class="table table-bordered" id="t1">
										<thead>
											<tr>
												<td>user</td>
												<td>pass</td>
												<td>ที่อยู่</td>
												<td colspan="3">ตำบล อำเภอ จังหวัด</td>
												<td>Manage</td>
											</tr>
										</thead>
										<tbody>

											<tr id="row1">
												<%-- <td><form:input path="user"  name="members[0].user" /></td>
													<td><form:input path="pass" /></td>
													<td><form:input path="address" /></td>
													<td><form:select id="districts"
															path="districts.districtId" /></td>
													<td><form:select id="amphures"
															path="districts.amphures.amphurId" /></td>
													<td><form:select id="provinces"
															path="districts.amphures.provinces.id"
															items="${provincesList }" /></td>
													<td><input type="submit" name="action" value="Add" />
													</td> --%>
												<td><input type="text" id="user" name="members[0].user" /></td>
												<td><input type="text" id="pass" name="members[0].pass" /></td>
												<td><input type="text" id="address"
													name="members[0].address" /></td>
												<td><select id="districts"
													name="members[0].districts.districtId" /></td>
												<td><select id="amphures" name="districts.amphures" /></td>
												<td><form:select path="districts.amphures.provinces"
														id="provinces" items="${provincesList }" /></td>
												<td><input type="submit" name="action" value="Add"
													id="add" /></td>
											</tr>
										</tbody>
									</table>
									<button id="addAll">Add All</button>
								</form:form>
							</div>
						</div>

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
										<tr>
											<td></td>
											<td></td>
											<td><input type="text" id="userSearch"></td>
											<td><input type="text" id="nameSearch"></td>
											<td><input type="text" id="createdSearch"></td>
											<td><input type="text" id="addressSearch"></td>
											<td><input type="text" id="districtSearch"></td>
											<td colspan="2">Manage</td>
										</tr>
									</thead>
									<tbody id="contents">
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
												<td><input type="submit" name="action" value="Edit" />
													<input type="submit" name="action" value="Delete" /> <input
													type="submit" name="action" value="Search" /></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		/********************************/
		/******* change provinces******/
		/******************************/
		$(document).on('change', '#provinces', function(e) {
			var id = $('[id=provinces]').index(e.target);
			var val = $('[id=provinces]').eq(id).val();
			$('[id=amphures]').eq(id).html("");
			$('[id=districts]').eq(id).html("");
			$('[id=amphures]').eq(id).load('address/amphures', {
				id : val
			});
		});

		/********************************/
		/******* change amphures******/
		/******************************/
		$(document).on('change', '#amphures', function(e) {
			var id = $('[id=amphures]').index(e.target);
			var val = $('[id=amphures]').eq(id).val();
			$('[id=districts]').eq(id).html("");
			$('[id=districts]').eq(id).load('address/districts', {
				id : val
			});
		});
		
		/********************************/
		/*******      add member   ******/
		/******************************/
		$(document).on('click', '#add', function(e) {
			
			var id = $('[id=add]').index(e.target);
			var user = $('[id=user]').eq(id).val();
			var pass = $('[id=pass]').eq(id).val();
			var address = $('[id=address]').eq(id).val();
			var districts = $('[id=districts]').eq(id).val();
			$.ajax({
				type:'POST',
				url:'member/create',
				data:{user : user,pass:pass,address:address,'districts.districtId':districts,action:'Add'}
			}).success(function(msg){
				alert('success ');
				 $('[id=user]').eq(id).val('');
				var pass = $('[id=pass]').eq(id).val('');
				var address = $('[id=address]').eq(id).val('');
				var districts = $('[id=districts]').eq(id).val('');
				$("#contents").html(msg);
			}).fail(function(msg){
				alert('failed ');
			});
			e.preventDefault();
		});
		
		/********************************/
		/******      add members   ******/
		/******************************/
		$(document).on('click', '#addAll', function(e) {			
			$.ajax({
				type:'POST',
				url:'member/creates',
				data:$('#members').serialize(),
			}).success(function(msg){
				alert('success ');
				$("#contents").html(msg);
			}).fail(function(msg){
				alert('failed ');
			});
			e.preventDefault();
			$('#members')[0].reset();
		});

		/********************************/
		/******* add 10 <tr></tr>******/
		/******************************/
		var tr_id = 1, name_id = 1;
		$("#p10")
				.click(
						function() {
							for (var i = 0; i < 10; i++) {
								$("table tr#row1")
										.clone()
										.find('input,select')
										.each(
												function(e) {
													/* $(this).val('').attr('id', function(_, id) {
														return id + tr_id
													}); */
													if ($(this).attr('name')) {
														var item = $(this)
																.attr('type') == "submit" ? $(this)
																: $(this).val('');
														item.attr('name',function(_,id) {
																			var name1 = id.split("[");
																			if (name1.length == 2) {
																				var name2 = name1[1].split("]");
																				var name = name1[0]+ "["+ name_id+ "]"+ name2[1];
																				return name;
																			} else {
																				return id;
																			}
																		});
													}
												}).end().appendTo("table#t1")
										.removeAttr("id");
								tr_id++;
								name_id++;
							}
							return false;
						});
		
		/*****************************/
		/****** search on enter ******/
		/****************************/
		$(document).on("keypress","#userSearch,#nameSearch,#addressSearch,#createdSearch,#districtSearch",function(e){
			$.ajax({
				type:'POST',
				url:'member/creates',
				data:$('#members').serialize(),
			}).success(function(msg){
				alert('success ');
				$("#contents").html(msg);
			}).fail(function(msg){
				alert('failed ');
			});
			e.preventDefault();
			$('#members')[0].reset();
		});
	</script>
</body>
</html>