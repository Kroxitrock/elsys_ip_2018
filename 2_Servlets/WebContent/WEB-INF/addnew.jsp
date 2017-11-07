<%--
  Created by IntelliJ IDEA.
  User: anstr
  Date: 11/7/2017
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New User</title>
    </head>
    <body>
        <form action="new" method="POST">
            ID: <input type="text" name="id"/><br />
            Email: <input type="text" name="email"/><br />
            Name: <input type="text" name="name"/><br />
            Password: <input type="password" name="password"/><br />
            <input type="submit" value="create"/>
        </form>
    </body>
</html>
