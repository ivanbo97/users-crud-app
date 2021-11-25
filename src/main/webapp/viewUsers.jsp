<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<style><%@include file="/resources/css/page.css"%></style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1>List of Users</h1>
	<br><br>
	<table class="center" border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th colspan="2">Actions</th>
		</tr>
		<c:forEach items="${applicationScope.users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td><a href="updateRequest?id=${user.id}">Edit</a></td>
				<td><a href="delete?id=${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>
</body>
</html>