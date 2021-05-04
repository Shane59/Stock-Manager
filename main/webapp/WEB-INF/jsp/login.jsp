<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/responsiveIncludeMeta.jsp"></jsp:include>
<title>Food Stock Manager</title>
</head>
<body>
	<h1>Welcome to Food Stock Manager</h1>
	<form action="/StockManager/LoginServlet" method="post">
		<label>User Name:</label>
		<input type="text" name="userName"><br>
		<label>Password:</label>
		<input type="password" name="password"><br>
		<input type="submit" value="login"/>
	</form>
</body>
</html>