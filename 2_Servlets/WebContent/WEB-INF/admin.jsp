<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
		</tr>
		<form action="search" method = "post" >
			Search<input type="text" name="search" />
			<input type="submit" value="Search"/>
		</form>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.ID}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="user?name=${user.name}">Go to user page</a></td>
				<form action = "/del" method = "delete">
					<input type = "hidden" name = "username" value="${user.name}"/>
					<td><input type="submit" value="Delete"/></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	<form action = "/logout" method = "POST">
		<input type="submit" value="logout"/>
	</form>
	<form action = "/trans" method = "POST">
		<input type="submit" value="New User"/>
	</form>
</body>
</html>