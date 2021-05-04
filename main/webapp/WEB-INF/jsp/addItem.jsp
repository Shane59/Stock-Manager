<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/responsiveIncludeMeta.jsp"></jsp:include>
</head>
<body>
	<h1>Add a new item!</h1>
	<c:if test="${errorMsg.length() > 0}">
		<p>${errorMsg}</p>
	</c:if>
	<form action="/StockManager/AddItemServlet" method="post">
		<label>name</label><br>
		<input type="text" name="name"><br>
		<label>description</label><br>
		<input type="text" name="description"><br>
		<label>expiration date(yyyy-mm-dd)</label><br>
		<input type="text" name="expDate"><br>
		<input type="submit" value="add">
		<a href="/StockManager/ItemServlet">Cancel</a>
	</form>
</body>
</html>