<%@page import="model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Item> itemList = (List<Item>) application.getAttribute("itemList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Stock Manager</title>
<jsp:include page="/responsiveIncludeMeta.jsp"></jsp:include>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="m-10">
	<h1>Here are your food for emergency!</h1>
	<c:if test="itemList.size() > 0"><h1>hi</h1></c:if>
	<div class="container">
		<div class="row border-bottom mb-10">
			<div class="col">Name</div>
			<div class="col">Description</div>
			<div class="col">Expiration Date</div>
			<div class="col"></div>
		</div>
		<c:forEach var="item" items="${itemList}">
				<div class="row">
					<div class="col"><c:out value="${item.name}"></c:out></div>
					<div class="col"><c:out value="${item.description}"></c:out></div>
					<div class="col"><c:out value="${item.expDate}"></c:out></div>
					<div class="col">
						<form action="/StockManager/EditServlet">
							<input type="hidden" name="itemId" value="${item.id}">
							<input type="submit" value="edit">
						</form>
					</div>
				</div>
		</c:forEach>
	</div>
	<a href="/StockManager/AddItemServlet">Add more items</a>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>