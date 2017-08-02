<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel=stylesheet>
</head>
<body>
	<div class="row" style="margin-top:50px;">
		<div class="col-md-6 col-md-offset-3">
			<form action="auth" method="post">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						name="username"
						class="form-control" id="username" placeholder="Username">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password"
						class="form-control" id="password" placeholder="Password">
				</div>
				<div class="checkbox">
					<label> <input type="checkbox"> Check me out
					</label>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>