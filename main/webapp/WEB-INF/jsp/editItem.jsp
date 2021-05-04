<%@page import="model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Item editItem = (Item) session.getAttribute("editItem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Manager</title>
<jsp:include page="/responsiveIncludeMeta.jsp"></jsp:include>
</head>
<body>
	<h1>Edit your item!</h1>
	<form action="/StockManager/EditServlet" method="post">
		<label>name</label><br>
		<input type="text" name="name" value="${editItem.name}"><br>
		<label>description</label><br>
		<input type="text" name="description" value="${editItem.description}"><br>
		<label>expiration date(yyyy-mm-dd)</label><br>
		<input type="text" name="expDate" value="${editItem.expDate}"><br>
		<input type="hidden" name="id" value="${editItem.id}">
		<input type="submit" name="edit" value="Confirm">
		<input type="submit" name="delete" value="Delete">
		<a href="/StockManager/ItemServlet">Cancel</a>
	</form>
</body>
</html>