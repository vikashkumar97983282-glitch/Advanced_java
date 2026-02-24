<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h2>Add user</h2>
<form  action="save" method="post">
Name:<input type = "text" name="name"></br>
Email:<input type = "text" name = "email"></br>
<input type = "submit" value="Save"/>
</form>
<h2>User List</h2>
<c:foreach var="u" items="${list}">
${u.id} ${u.name} ${u.email}<br>
</c:foreach>
</body>
</html>