<%@ page import="org.elsys.ip.servlet.service.UserService" %>
<%@ page import="org.elsys.ip.servlet.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My first jsp</title>
	</head>
	<body>
		<p>Hello, world!</p>
		<c:if test="${error != null}">
			<p>${error}</p>
		</c:if>
		<%
			User user = null;
			UserService users = new UserService();
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				if(c.getName().equals("username")){
					if(((user  = users.getByName(c.getValue())) != null)){
						for(Cookie cc : cookies) {
							if(cc.getName().equals("password")){
								if(cc.getValue().equals(user.getPassword())) {
									UserService.setLoggedIn(user);
									RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
									dispatcher.forward(request, response);
								}
							}
						}
					}
				}
			}
		%>
		<form action="admin" method="POST">
			Name: <input type="text" name="name"/><br />
			Password: <input type="password" name="password"/><br />
			<input type="submit" value="login"/>
		</form>

	</body>
</html>